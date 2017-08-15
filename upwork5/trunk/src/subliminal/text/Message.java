package subliminal.text;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *
 * @author Ash
 */
public class Message extends JWindow{
    
    public Message() {
        super();
        this.setSize(500, 400);
        this.setLocation(300, 300);
        setBackground(new Color(0, 0, 0, 0));
        setAlwaysOnTop(true);
        JLabel testLabel = new JLabel("Floating text hah");
        this.add(testLabel);
    }
    
//    @Override
//    public void setVisible(boolean b) {
//        super.setVisible(b);
//        AWTUtilities.setWindowOpaque(this, false);
//    }
    
}
