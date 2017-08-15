package MindCastr.persistent;

import MindCastr.components.visionboard.ImageItem;
import static MindCastr.persistent.DirectoryManager.CreateFolderIfNotExist;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import MindCastr.utils.Sizes;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import org.apache.commons.io.FileUtils;

public class ImageUtil {

    private static final String imagesFolderName;
    private static final String lightImagesFolderName;

    static {
            imagesFolderName = getMindCastrFolder() + File.separator + "Images";
            lightImagesFolderName = imagesFolderName + File.separator + "Light";
            CreateFolderIfNotExist(lightImagesFolderName);
    }

    public static BufferedImage loadImage(String sourceImageUrl) {
        BufferedImage lightBufferedImage;
        if(!sourceImageUrl.startsWith(lightImagesFolderName)) {
           // JOptionPane.showMessageDialog(null, System.getProperty("os.name" ));
            String newImageName = getImageName(sourceImageUrl);
            String lightImageUrl = getLightImageUrl(newImageName);
            lightBufferedImage = copyLightImage(sourceImageUrl, lightImageUrl);
            copyImage(sourceImageUrl, newImageName);
        } else {
            BufferedImage originalImageBuffer = getBufferedImage(sourceImageUrl);
            lightBufferedImage = getVisibleImage(originalImageBuffer);
        }

        return lightBufferedImage;
    }

    public static BufferedImage loadAndSaveImage(String sourceImageUrl, String imageName) {
        BufferedImage bufferedImage = getBufferedImageFromURL(sourceImageUrl);
        String localPath = imagesFolderName + File.separator + imageName;
        if(bufferedImage == null) {
            bufferedImage = getBufferedImage(localPath);
        }else {
            File outputfile = new File(localPath);
            try {
                ImageIO.write(bufferedImage, "png", outputfile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return bufferedImage;
    }

    static String getImageName(String sourceImageUrl) {
        File sourceFile = new File(sourceImageUrl);
        File destinationDirectory = new File(lightImagesFolderName);
        //JOptionPane.showMessageDialog(null,lightImagesFolderName);
        String newFileName = sourceFile.getName();
        assert(destinationDirectory.exists());
        File[] filesInDestinationFolder = destinationDirectory.listFiles();
        assert(filesInDestinationFolder != null);
        Set<String> existingFileNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for(File file : filesInDestinationFolder) {
            if(file.isFile()) {
                String fileName = file.getName();
                existingFileNames.add(fileName);
            }
        }
        //does file name conain the extension???
        //check and fix for Windows and MacOS
        Random rand = new Random();
        while(existingFileNames.contains(newFileName)) {
            String[] fileAndExtension = splitFileAndExtension(newFileName);
            newFileName = fileAndExtension[0] + rand.nextInt(1000) + (!fileAndExtension[1].isEmpty() ? "." + fileAndExtension[1] : "");
        }
        return newFileName;
    }

    static void copyImage(String imageUrl, String newName) {
        assert(imageUrl != null && !imageUrl.isEmpty());
        File sourceFile = new File(imageUrl);
        assert(sourceFile.exists());
        File destinationDirectory = new File(imagesFolderName);
        assert(destinationDirectory.exists());
        String newFileUrl = imagesFolderName + File.separator + newName;
        File destFile = new File(newFileUrl);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException ex) {
            ex.printStackTrace();
            assert(false);
        }
    }

    private static BufferedImage copyLightImage(String sourceImageUrl, String destImageUrl) {
        return copyLowerQualityImage(sourceImageUrl, destImageUrl, 0.2f);
    }

    public static BufferedImage getBufferedImage(String imageUrl) {
        File imageFile = new File(imageUrl);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(imageFile);
        } catch (IOException ex) {
            System.out.println("cannot read image, path = " + imageUrl);
            ex.printStackTrace();
            assert(false);
        }
        return originalImage;
    }

    public static BufferedImage getBufferedImageFromURL(String imageUrl) {
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new URL(imageUrl));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return originalImage;
    }

    public static BufferedImage getVisibleImage(BufferedImage originalImage) {
        Dimension imageSize = ImageItem.calcAndGetVisibleImageSize(new Dimension(originalImage.getWidth(), originalImage.getHeight()));
        BufferedImage resultImage = new BufferedImage(imageSize.width, imageSize.height, originalImage.getType());
        Graphics2D g = resultImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imageSize.width, imageSize.height, null);
        g.dispose();
        return resultImage;
    }

    public static BufferedImage getImageForScreen(BufferedImage originalImage) {
        Dimension screenSize = Sizes.getScreenSize();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        if(width > screenSize.width || height > screenSize.height) {
            double imageWidthHeight = (double)width/height;
            double contWidthHeight = (double)screenSize.width/screenSize.height;
            Double resizeFactor;
            if(imageWidthHeight >= contWidthHeight) {
                //width is the pivotal
                resizeFactor = (double)screenSize.width/width;
            } else {
                //height is the pivotal
                resizeFactor = (double)screenSize.height/height;
            }
            width = (int)(resizeFactor * width);
            height = (int)(resizeFactor * height);
        }
        BufferedImage resultImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g = resultImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resultImage;
    }

    private static BufferedImage copyLowerQualityImage(String sourceImageUrl, String destImageUrl, float quality) {
        File destFile = new File(destImageUrl);
        String[] splitFileAndExtension = splitFileAndExtension(sourceImageUrl);
        String extension = splitFileAndExtension[1];
        Iterator iter = ImageIO.getImageWritersByFormatName(extension);
        ImageWriter writer = (ImageWriter)iter.next();
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        BufferedImage originalImage = getBufferedImage(sourceImageUrl);
        BufferedImage resultBufferedImage = null;
        if(iwp.canWriteCompressed()) {
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality(quality);
            FileImageOutputStream output = null;
            try {
                IIOImage image = new IIOImage(originalImage, null, null);
                //write to file
                output = new FileImageOutputStream(destFile);
                writer.setOutput(output);
                writer.write(null, image, iwp);
                //write to result buffered image
                resultBufferedImage = getVisibleImage(originalImage);
            } catch (Exception ex) {
                ex.printStackTrace();
                assert(false);
            } finally {
                writer.dispose();
                if(output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            try {
                String[] destFileExtSplited = splitFileAndExtension(destImageUrl);
                String destExtension = destFileExtSplited[1];
                ImageIO.write(originalImage, destExtension, destFile);
                resultBufferedImage = getVisibleImage(originalImage);
            } catch (IOException ex) {
                ex.printStackTrace();
                assert(false);
            }
        }
        return resultBufferedImage;
    }

    public static void removeImage(String lightImageUrl) throws IOException {
        File fileToDelete = new File(lightImageUrl);
        assert(fileToDelete.exists());
        FileUtils.deleteQuietly(fileToDelete);
        String originalCopiedUrl = getImageUrl(fileToDelete.getName());
        fileToDelete = new File(originalCopiedUrl);
        assert(fileToDelete.exists());
        FileUtils.deleteQuietly(fileToDelete);
    }

    public static Dimension getImageDimension(String imageUrl) {
        File file = new File(imageUrl);
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
        int width = getWidth(imageIcon);
        int height = getHeight(imageIcon);
        return new Dimension(width, height);
    }

    private static int getWidth(ImageIcon imageIcon) {
        int width = imageIcon.getIconWidth();
        if (width > Sizes.getScreenWidth()){
            width = Sizes.getScreenWidth();
        }
        return width;
    }

    private static int getHeight(ImageIcon imageIcon) {
        int height = imageIcon.getIconHeight();
        if (height > Sizes.getScreenHeight()){
            height = Sizes.getScreenHeight();
        }
        return height;
    }

    //TODO: check and handle possible cases for MAC
    private static String[] splitFileAndExtension(String str) {
        if (str == null){
            return null;
        }

        int pos = str.lastIndexOf(".");

        if (pos == -1){
            return new String[] {str, ""};
        }
        return new String[] {str.substring(0, pos), str.substring(pos + 1)};
    }

    public static String getImageUrl(String imageName) {
        return imagesFolderName + File.separator + imageName;
    }

    public static String getLightImageUrl(String imageName) {
        return lightImagesFolderName + File.separator + imageName;
    }

    public static Dimension getImgSizeWithoutLoad(String filePath) {
//        System.out.println(String.format("Getting image size for %s", filePath));
        File imageFile = new File(filePath);
        ImageInputStream in = null;
        try {
            in = ImageIO.createImageInputStream(imageFile);
            final Iterator readers = ImageIO.getImageReaders(in);
            if (readers.hasNext()) {
                ImageReader reader = (ImageReader) readers.next();
                try {
                    reader.setInput(in);
                    return new Dimension(reader.getWidth(0), reader.getHeight(0));
                } catch (IOException ex) {
                } finally {
                    reader.dispose();
                }
            }
        } catch (IOException ex) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
        return null;
    }

}
