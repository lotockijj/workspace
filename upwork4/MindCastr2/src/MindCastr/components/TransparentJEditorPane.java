/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components;

import MindCastr.OS.Info.OSInfo;
import MindCastr.utils.Sizes;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JEditorPane;

/**
 *
 * @author Ash
 */
public class TransparentJEditorPane extends JEditorPane {
    
    private float transparencyFactor;

    public TransparentJEditorPane(String text, float transparencyFactor, Font font, Color foreground) {
        super();
        setOpaque(false);
        this.transparencyFactor = transparencyFactor;
        setText(text);
        setFont(font);
        setForeground(foreground);
        setBorder(null);
        int screenWidth = Sizes.getScreenWidth();
        Dimension oneLineTextDim = Sizes.getTextDimensionInPixels(text, font.getFontName(), font.getSize());
        //int correctionFactor = (OSInfo.getOSName().toLowerCase().indexOf("mac")) >= 0 ? 30 : 5;
        int correctionFactor = 75;
        int realTextWidth = Math.min(screenWidth, oneLineTextDim.width) + correctionFactor;
        int realTextHeight = getPreferredSize().height;
        //realTextWidth = screenWidth + 5/*in order not to be near the screen borders*/;
        if(oneLineTextDim.width >  screenWidth) {
            realTextHeight = realTextHeight * (oneLineTextDim.width / realTextWidth + 1);
        }
        
        setPreferredSize(new Dimension(realTextWidth, realTextHeight));
        Dimension preferredSize = getPreferredSize();
        setPreferredSize(preferredSize);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyFactor));
        super.paint(g2);
        g2.dispose();
    }

}
