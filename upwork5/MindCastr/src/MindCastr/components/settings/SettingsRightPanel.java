package MindCastr.components.settings;

import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class SettingsRightPanel extends JPanel {
    
    public final PanelMessageOrder panelMessageOrder;
    
    public SettingsRightPanel() {
        setLayout(new BorderLayout(0, 0));
        setOpaque(false);  
        //setBackground(Constants.MAIN_PANEL_COLOR);
         
        panelMessageOrder = new PanelMessageOrder();
        add(panelMessageOrder, BorderLayout.PAGE_START);
        JPanel dummyPanel = new JPanel();
        dummyPanel.setOpaque(false);
        add(dummyPanel, BorderLayout.CENTER);
    }
    
}
