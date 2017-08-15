package MindCastr.components.visionboard;

import MindCastr.components.visionboard.VisionItemContent.ContentType;
import MindCastr.constants.Constants;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

public class ImageItem extends VisionItem {

    //public static Dimension PREFERRED_SIZE = new Dimension((PanelVisionBoard.CONTENT_PANEL_PREFERRED_SIZE.width / 3), Constants.VISION_ITEM_HEIGHT - 10);
    public static int PREFERRED_WIDTH = (PanelVisionBoard.CONTENT_PANEL_PREFERRED_SIZE.width / 3);
    
    private static BufferedImage loadingBufferedImage;
    static {
        try {
            URL resource = ImageItem.class.getResource("/loading.jpg");
            loadingBufferedImage = ImageIO.read(resource);
        } catch (IOException ex) {
            assert(false);
        }
    }
    
//    private static final String immageHtmlFmt =
//            "<html>\n" +
//                "<div width=%d height=%d style=\"padding-top:%dpx;padding-bottom:%dpx;text-align:center;\">" +
//                        "<img src=\"file:%s\" width=%d height=%d>\n" +
//                "</div>" +
//            "</html>";

    private volatile BufferedImage bufferedImage;
    private final Dimension imageSize;
    //private String immageHtml;

    public ImageItem(String immageName, Dimension imageSize) {
        super(immageName);
        assert(loadingBufferedImage != null);
        this.bufferedImage = loadingBufferedImage;
        this.imageSize = calcAndGetVisibleImageSize(imageSize);
        setContentType("text/html");
        setPreferredSize(this.imageSize);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, Constants.MAIN_CONTENT_PANELS_COLOR));
        
    }
    
    public synchronized void changeImage(BufferedImage bufferedImage) {
        //VisionItemPanel
        this.bufferedImage = bufferedImage;
        repaint();
        revalidate();
        Container parent = getParent();
        while(parent != null && !(parent instanceof VisionItemPanel)) {
            parent = parent.getParent();
        }
        if(parent != null) {
            parent.repaint();
        }
    }
    
    public static Dimension calcAndGetVisibleImageSize(Dimension actualSize) {
        int width = actualSize.width;
        int height = actualSize.height;
        double factor = ((double)PREFERRED_WIDTH/actualSize.width);
        width = (int)(factor * width);
        height = (int)(factor * height);
        return new Dimension(width, height);
    }

    @Override
    public ContentType getContentTypeEnum() {
        return ContentType.IMAGE_URL;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        synchronized(this) {
            if(bufferedImage == null) {
                //to not have NPE in case if something wrong in image paths
                return;
            }
            //Dimension imageSize = calcAndGetVisibleImageSize(bufferedImage);
            int leftRightMargin = (imageSize.width - bufferedImage.getWidth())/2;
            int topBottomMargin = (imageSize.height - bufferedImage.getHeight())/2;
            g2d.drawImage(bufferedImage, null, leftRightMargin, topBottomMargin);
        }
    }
}
