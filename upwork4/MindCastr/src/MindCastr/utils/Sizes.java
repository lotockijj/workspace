package MindCastr.utils;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

public class Sizes {

    public static int getScreenWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        return width;
    }
    
    public static int getScreenHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) screenSize.getHeight();
        return height;
    }

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    public static Dimension getTextDimensionInPixels(String message, String fontName, int fontSize) {
        java.awt.Font font = new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize);
        FontMetrics metrics = new FontMetrics(font) {};
        Rectangle2D bounds = metrics.getStringBounds(message, null);
        int textWidthPixels = (int) bounds.getWidth() + 1;
        int textHeightPixels = (int) bounds.getHeight() + 1;
        return new Dimension(textWidthPixels, textHeightPixels);
    }
}
