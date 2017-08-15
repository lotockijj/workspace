package MindCastr.components.settings;

import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class SettingsMiddlePanel extends JPanel {
    
    public final PanelFont1 panelFont;
    
    public SettingsMiddlePanel() {
        setLayout(new BorderLayout(0, 0));       
        panelFont = new PanelFont1();
        add(panelFont, BorderLayout.PAGE_START);
        JPanel dummyPanel = new JPanel();
        setOpaque(false);       
        
        dummyPanel.setOpaque(false);
        dummyPanel.setBackground(Constants.MAIN_PANEL_COLOR);
        add(dummyPanel, BorderLayout.CENTER);
    }
    
}
