/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Ash
 */
public class TransparentPanel extends JPanel {
    
    private float transparencyFactor;
    
    public TransparentPanel() {
        this(1f);
    }
    
    public TransparentPanel(float transparencyFactor) {
        this(null, transparencyFactor);
    }
    
    public TransparentPanel(LayoutManager layout, float transparencyFactor) {
        super(layout);
        //setOpaque(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyFactor));
        super.paint(g2);
        g2.dispose();
    }
    
    public void changeTransparency(float transparencyFactor) {
        if(transparencyFactor >= 0f || transparencyFactor <= 1f) {
            this.transparencyFactor = transparencyFactor;
            this.repaint();
        }
    }
    
}
