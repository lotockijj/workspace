package MindCastr.message;

import MindCastr.components.TransparentImagePanel;
import MindCastr.components.TransparentJEditorPane;
import MindCastr.components.settings.SettingsConfig;
import MindCastr.components.settings.SettingsConfig.FontSettings;
import MindCastr.components.settings.SettingsConfig.MessageLocationEnum;
import MindCastr.components.settings.SettingsConfig.MessageLocationSettings;
import MindCastr.components.visionboard.VisionItemContent;
import MindCastr.components.visionboard.VisionItemContent.ContentType;
import javax.swing.JWindow;

import MindCastr.utils.Sizes;
import MindCastr.persistent.ImageUtil;
import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Subliminal extends JWindow {

    private JComponent previousComponent;
    
    public Subliminal() {
        super();
        setAlwaysOnTop(true);
        AWTUtilities.setWindowOpaque(this, false);
    }
    
    public void setContent(VisionItemContent itemContent) {
        FontSettings fontSettings = SettingsConfig.getInstance().getFontSettings();
        MessageLocationSettings messageLocationSettings = SettingsConfig.getInstance().getMessageLocationSettings();
        Dimension subliminalMsgDimInPixels;
        JComponent newComponentToShow;
        if (itemContent.type == ContentType.TEXT) {
            Font font = new Font(fontSettings.font, Font.PLAIN, fontSettings.fontSize);;
            newComponentToShow = new TransparentJEditorPane(itemContent.subliminalContent, ((float)fontSettings.transparency)/100, font, fontSettings.color);
            subliminalMsgDimInPixels = newComponentToShow.getPreferredSize();
               // JOptionPane.showMessageDialog(null, itemContent.subliminalContent);
            //subliminalMsgDimInPixels.width += 120;
        } else {
            assert(itemContent.type == ContentType.IMAGE_URL);
            File imageFile = new File(itemContent.subliminalContent);
            String imageName = imageFile.getName();
            String imageUrl = ImageUtil.getImageUrl(imageName);
            BufferedImage image = ImageUtil.getBufferedImage(imageUrl);
            BufferedImage imageForScreen = ImageUtil.getImageForScreen(image);
            subliminalMsgDimInPixels = new Dimension(imageForScreen.getWidth(), imageForScreen.getHeight());
            newComponentToShow = new TransparentImagePanel(imageForScreen, ((float)fontSettings.transparency)/100);
            newComponentToShow.putClientProperty(this, image);
        }
        newComponentToShow.setDoubleBuffered(true);
        
        if(previousComponent != null) {
            getContentPane().remove(previousComponent);
        }
        getContentPane().add(newComponentToShow);
        previousComponent = newComponentToShow;
        
        Point locationOnScreen = getLocationOnScreen(subliminalMsgDimInPixels, messageLocationSettings.messageLocation);
        this.setLocation(locationOnScreen);
        pack();
    }
    
    private static Point getLocationOnScreen(Dimension messageSize, MessageLocationEnum messageLocation) {
        Point result;
        int messageX = -1;
        int messageY = -1;
        Dimension screenSize = Sizes.getScreenSize();
        switch(messageLocation) {
            case RANDOM:
                Random rand = new Random();
                int maxWidth = Math.max(screenSize.width - messageSize.width, 1);
                messageX = rand.nextInt(maxWidth);
                int maxHeight = Math.max(screenSize.height - messageSize.height, 1);
                messageY = rand.nextInt(maxHeight);
                break;
            case CENTER:
                messageX = (int)(((double)screenSize.width)/2 - ((double)messageSize.width)/2);
                messageY = (int)(((double)screenSize.height)/2 - ((double)messageSize.height)/2);
                break;
            case BOTTOM_RIGHT:
                messageX = (screenSize.width - messageSize.width);
                messageY = (screenSize.height - messageSize.height);
                break;
            default:
                assert(false);
                break;
                
        }
        assert(messageX != -1 && messageY != -1);
        result = new Point(messageX, messageY);
        return result;
    }
}
