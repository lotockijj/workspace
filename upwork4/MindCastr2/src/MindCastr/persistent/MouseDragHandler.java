package MindCastr.persistent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseDragHandler extends MouseMotionAdapter {
    private int mx, my;
    private JFrame frame;

    public MouseDragHandler(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mx = e.getXOnScreen();
        this.my = e.getYOnScreen();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String message = "XXX";
        if (e.getSource() != null && e.getSource().getClass() != null) {
            message = e.getSource().getClass().toString();
        }
        //JOptionPane.showMessageDialog(MainWindow.this, e.getSource().getClass(), "mouseDragged", JOptionPane.INFORMATION_MESSAGE);
        Point p = frame.getLocation();
        p.x += e.getXOnScreen() - mx;
        p.y += e.getYOnScreen() - my;
        mx = e.getXOnScreen();
        my = e.getYOnScreen();
        frame.setLocation(p);
    }
}
