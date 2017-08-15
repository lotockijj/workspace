package MindCastr.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utils {

    public static ImageIcon getIcon(String url, int size) {
        Image newImg = getResizedImage(url, size, size);
        return new ImageIcon(newImg);
    }
    
    public static Icon getIcon(String url, int width, int heigth) {
        Image newImg = getResizedImage(url, width, heigth);
        return new ImageIcon(newImg);
    }
    
    public static Image getResizedImage(String url, int width, int height) {
        ImageIcon imgIcon = new ImageIcon(Utils.class.getResource(url));
        Image img = imgIcon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return newImg;
    }

    public static BufferedImage getBufferedImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Utils.class.getResource(path));
        } catch (IOException e) {
            System.err.println("Couldn't find file: " + path);
            return null;
        }

        return img;
    }

    public static String getExtension(File f) {
        String ext = null;
        String name = f.getName();
        int i = name.lastIndexOf('.');
        if (i > 0 && i < name.length() - 1) {
            ext = name.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Utils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static String getJarFilePath() {
        String path = Utils.class.getProtectionDomain().
                getCodeSource().getLocation().getPath();
        path = path.substring(0, path.lastIndexOf("/"));
        path = path.replace("%20", " ");
        path += "/";
        //path = path.substring(0, path.length()-1);
        //path += File.separator;
        return path;
    }

    public static void msgBox(String Title) throws IOException {
        JFrame msgBox = new JFrame(Title);
        msgBox.setIconImage(ImageIO.read(Utils.class.getClass().getResource("/icon.png")));
        JLabel message = new JLabel("This copy of MindCastr is not genuine.");
        message.setFont(new Font("Serif", Font.BOLD, 12));
        message.setPreferredSize(new Dimension(1000,500));
        message.setSize(1000,500);
        JLabel message2 = new JLabel("Please contact Info@MindCastr.com for more information.");
        message2.setFont(new Font("Serif", Font.PLAIN, 10));
        message2.setPreferredSize(new Dimension(400,100));
        msgBox.setResizable(false);
        msgBox.add(message);
//        msgBox.setPreferredSize(new Dimension(1000,1000));
        msgBox.setVisible(true);
        msgBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        msgBox.add(message2);
        msgBox.setLocationRelativeTo(null);
        msgBox.pack();
    }
    
    public static void printMemoryInfo() {
        int toMegFactor = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory()/toMegFactor;
        long totalMemory = runtime.totalMemory()/toMegFactor;
        long freeMemory = runtime.freeMemory()/toMegFactor;
        System.out.println("maxMem = " + maxMemory + ", totalMem = " + totalMemory + ", usedMem = " + (totalMemory - freeMemory) + ", freeMem = " + freeMemory);
    }

    public static void cleanup(File f) {
        if (f.exists()) {
            for (File ff : f.listFiles()) {
                if (ff.isDirectory()) cleanup(ff);
                ff.delete();
            }
            f.delete();
        }
    }

    public static boolean exists(File f) {
        return (f.exists() && !f.isDirectory());
    }
}
