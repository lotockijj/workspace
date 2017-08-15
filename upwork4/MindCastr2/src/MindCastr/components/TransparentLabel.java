package MindCastr.components;

import java.awt.AlphaComposite;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.JLabel;

public class TransparentLabel extends JLabel {
    
    private float transparencyFactor;
    
    public TransparentLabel() {
        super();
        setOpaque(false);
        this.transparencyFactor = 1f;
    }
    
    public TransparentLabel(float transparencyFactor) {
        super();
        setOpaque(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    public TransparentLabel(String text, float transparencyFactor) {
        super(text);
        setOpaque(false);
        this.transparencyFactor = transparencyFactor;
    }

    public TransparentLabel(Icon icon, float transparencyFactor) {
        super(icon);
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
    
    public void changeTransparency(float transparencyFactor) {
        if(transparencyFactor >= 0f || transparencyFactor <= 1f) {
            this.transparencyFactor = transparencyFactor;
            this.repaint();
            Container parent = this.getParent();
            if(parent != null) {
                parent.repaint();
            }
        }
    }
    
    public float getTransparencyFactor() {
        return transparencyFactor;
    }
    
}
