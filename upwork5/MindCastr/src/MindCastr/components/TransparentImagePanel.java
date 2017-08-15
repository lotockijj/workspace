/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components;

import MindCastr.image.ImagePanel;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Ash
 */
public class TransparentImagePanel extends ImagePanel {

    private float transparencyFactor;
    
    public TransparentImagePanel(Image img, float transparencyFactor) {
        super(img);
        setOpaque(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyFactor));
        super.paint(g2);
        g2.dispose();
    }
    
}
