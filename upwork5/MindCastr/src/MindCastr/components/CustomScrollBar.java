package MindCastr.components;

import MindCastr.constants.Constants;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class CustomScrollBar extends BasicScrollBarUI {
    private Color THUMB_COLOR;
    private Color BORDER_COLOR;

    public CustomScrollBar(Color color) {
        this.THUMB_COLOR = color;
    }

    public CustomScrollBar(Color color, Color borderColor) {
        this.THUMB_COLOR = color;
        this.BORDER_COLOR = borderColor;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(THUMB_COLOR);
        g2.drawRect(r.x, r.y, r.width, r.height);
        g2.fillRect(r.x, r.y, r.width, r.height);
        g2.setPaint(this.BORDER_COLOR);
        g2.drawRect(r.x, r.y, r.width-1, r.height);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }


    @Override
    protected void configureScrollBarColors() {
        super.configureScrollBarColors();
        thumbColor = Constants.SCROLLBAR_THUMB_COLOR;
    }


    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton jbutton = new JButton();
        jbutton.setPreferredSize(new Dimension(0, 0));
        jbutton.setMinimumSize(new Dimension(0, 0));
        jbutton.setMaximumSize(new Dimension(0, 0));
        return jbutton;
    }

}