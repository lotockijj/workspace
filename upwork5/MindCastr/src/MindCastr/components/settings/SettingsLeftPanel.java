package MindCastr.components.settings;

import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SettingsLeftPanel extends JPanel {
    
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.LEFT_PANEL_PREFERRED_WIDTH, PanelSettings.MAIN_PANEL_HEIGHT);
    public static final int TIME_SETTINGS_PREFERRED_HIGHT = (int)(0.23 * PREFFERED_SIZE.height);
    public static final int MESSAGE_LOCATION_PREFERRED_HIGHT = (int)(0.24 * PREFFERED_SIZE.height);
    public static final int CATEGORIES_PREFERRED_HIGHT = (int)(0.53 * PREFFERED_SIZE.height);
    
    public final PanelTimeSettings panelTimeSettings;
    public final PanelMessageLocation panelMessageLocation;
    
    public SettingsLeftPanel() {
        setLayout(new BorderLayout(0, 2));
        
        setOpaque(false);
        setPreferredSize(PREFFERED_SIZE);
        panelTimeSettings = new PanelTimeSettings();
        panelMessageLocation = new PanelMessageLocation();
        add(panelTimeSettings, BorderLayout.NORTH);
        add(panelMessageLocation, BorderLayout.CENTER);
        add(new PanelCategories(), BorderLayout.SOUTH);
        
    }
}
