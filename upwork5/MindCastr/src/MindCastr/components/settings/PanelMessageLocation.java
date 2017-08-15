package MindCastr.components.settings;

import static MindCastr.components.settings.SettingsConfig.MessageLocationEnum.RANDOM;
import MindCastr.components.settings.SettingsConfig.MessageLocationSettings;
import MindCastr.constants.Constants;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JRadioButton;

public class PanelMessageLocation extends PanelTitled {
    
    private ButtonGroup msgLocationButtonGroup;
    
    private JRadioButton randomRadioButton;
    private JRadioButton centerRadioButton;
    private JRadioButton bottomRadioButton;
    
    private final MessageLocationSettings messageLocationSettings;

    public PanelMessageLocation() {
        super("Message Location", new Dimension(PanelSettings.LEFT_PANEL_PREFERRED_WIDTH, SettingsLeftPanel.MESSAGE_LOCATION_PREFERRED_HIGHT));
        messageLocationSettings = SettingsConfig.getInstance().getMessageLocationSettings();
        initComponents();
        setUpLayout();
    }
    
    private void initComponents() {
        msgLocationButtonGroup = new ButtonGroup();
        randomRadioButton = new JRadioButton("Display Randomly On Screen");
        msgLocationButtonGroup.add(randomRadioButton);
        randomRadioButton.setFont(Constants.INNER_COMPONENT_FONT);
        randomRadioButton.setForeground(Constants.TEXT_COLOR);
        randomRadioButton.setOpaque(false);
        randomRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(randomRadioButton.isSelected()) {
                    messageLocationSettings.messageLocation = SettingsConfig.MessageLocationEnum.RANDOM;
                }
            }
        });
        
        centerRadioButton = new JRadioButton("Display Center Of Screen");
        msgLocationButtonGroup.add(centerRadioButton);
        centerRadioButton.setFont(Constants.INNER_COMPONENT_FONT);
        centerRadioButton.setForeground(Constants.TEXT_COLOR);
        centerRadioButton.setOpaque(false);
        centerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(centerRadioButton.isSelected()) {
                    messageLocationSettings.messageLocation = SettingsConfig.MessageLocationEnum.CENTER;
                }
            }
        });
        
        bottomRadioButton = new JRadioButton("Display Bottom Right Of Screen");
        msgLocationButtonGroup.add(bottomRadioButton);
        bottomRadioButton.setFont(Constants.INNER_COMPONENT_FONT);
        bottomRadioButton.setForeground(Constants.TEXT_COLOR);
        bottomRadioButton.setOpaque(false);
        bottomRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bottomRadioButton.isSelected()) {
                    messageLocationSettings.messageLocation = SettingsConfig.MessageLocationEnum.BOTTOM_RIGHT;
                }
            }
        });
    }
    
    public final void initComponentValues() {
        switch (messageLocationSettings.messageLocation) {
            case RANDOM:
                randomRadioButton.setSelected(true);
                break;
            case CENTER:
                centerRadioButton.setSelected(true);
                break;
            case BOTTOM_RIGHT:
                bottomRadioButton.setSelected(true);
                break;
        }
    }

    private void setUpLayout() {
        GroupLayout messageLocationPanelLayout = new GroupLayout(mainPanel);
        setLayout(messageLocationPanelLayout);
        
        messageLocationPanelLayout.setHorizontalGroup(
            messageLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLocationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(messageLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(randomRadioButton)
                    .addComponent(centerRadioButton)
                    .addComponent(bottomRadioButton))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        messageLocationPanelLayout.setVerticalGroup(
            messageLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLocationPanelLayout.createSequentialGroup()
                .addComponent(randomRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(centerRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomRadioButton))
        );
    }
    
}
