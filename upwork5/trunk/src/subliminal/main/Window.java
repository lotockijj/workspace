/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subliminal.main;

import com.sun.awt.AWTUtilities;
import subliminal.text.Message;
import javax.swing.JWindow;
import subliminal.panels.Config;

/**
 *
 * @author Ashxb xcv xcv zb4758456
 */
public class Window {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Message tMess = new Message();
        tMess.setVisible(true);
        
        JWindow wind = new JWindow();
        wind.add(new Config());
        wind.pack();
        wind.setVisible(true);
    }
}
