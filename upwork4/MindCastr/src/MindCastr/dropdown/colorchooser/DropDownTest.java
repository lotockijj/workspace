package MindCastr.dropdown.colorchooser;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DropDownTest extends JPanel {

    public static void main(String[] args) {
        JLabel lbl = new JLabel("Drop Down Test");
        DropDownColorChooser ddChooser = new DropDownColorChooser(lbl);
        JFrame frame = new JFrame("Drop Down Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add("North", ddChooser);
        frame.getContentPane().add("Center", lbl);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
