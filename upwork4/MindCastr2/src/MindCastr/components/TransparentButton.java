package MindCastr.components;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.JButton;

public class TransparentButton extends JButton {
    private float transparencyFactor;
    
    public TransparentButton() {
        super();
        setOpaque(false);
        setFocusable(false);
        this.transparencyFactor = 1f;
    }
    
    public TransparentButton(float transparencyFactor) {
        super();
        setOpaque(false);
        setFocusable(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    public TransparentButton(String text, float transparencyFactor) {
        super(text);
        setOpaque(false);
        setFocusable(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    public TransparentButton(Icon icon, float transparencyFactor) {
        super(icon);
        setOpaque(false);
        setFocusable(false);
        this.transparencyFactor = transparencyFactor;
    }
    
    public TransparentButton(String text, Icon icon, float transparencyFactor) {
        super(text, icon);
        setOpaque(false);
        setFocusable(false);
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
