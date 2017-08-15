package MindCastr.components.settings;

import MindCastr.components.settings.SettingsConfig.MessageOrderSettings;
import MindCastr.constants.Constants;
import MindCastr.panels.MainWindow;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle;

public class PanelMessageOrder extends PanelTitled {
    
    private static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.RIGHT_PANEL_PREFERRED_WIDTH, (int) (0.16 * MainWindow.MAIN_PANEL_PREFFERED_SIZE.height));
    
    private ButtonGroup messageOrderButtonGroup;
    private JCheckBox orderedCheckBox;
    private JCheckBox randomCheckBox;
    
    private final MessageOrderSettings messageOrderSettings;
    
    public PanelMessageOrder() {
        super("Message Order", PREFFERED_SIZE);
        messageOrderSettings = SettingsConfig.getInstance().getMessageOrderSettings();
        initComponents();
        setUpLayout();
    }
    
    private void initComponents() {
        messageOrderButtonGroup = new ButtonGroup();
        
        orderedCheckBox = new JCheckBox("Ordered");
        orderedCheckBox.setOpaque(false);
        messageOrderButtonGroup.add(orderedCheckBox);
        orderedCheckBox.setFont(Constants.INNER_COMPONENT_FONT);
        orderedCheckBox.setForeground(Constants.TEXT_COLOR);
        orderedCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(orderedCheckBox.isSelected()) {
                    messageOrderSettings.isOrdered = true;
                }
            }
        });
        
        randomCheckBox = new JCheckBox("Random");
        randomCheckBox.setOpaque(false);
        messageOrderButtonGroup.add(randomCheckBox);
        randomCheckBox.setFont(Constants.INNER_COMPONENT_FONT);
        randomCheckBox.setForeground(Constants.TEXT_COLOR);
        randomCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(randomCheckBox.isSelected()) {
                    messageOrderSettings.isOrdered = false;
                }
            }
        });
    }
    
    public final void initComponentValues() {
        if(messageOrderSettings.isOrdered) {
            orderedCheckBox.setSelected(true);
        } else {
            randomCheckBox.setSelected(true);
        }
    }
    
    private void setUpLayout() {
        GroupLayout messageOrderPanelLayout = new GroupLayout(mainPanel);
        setLayout(messageOrderPanelLayout);
        messageOrderPanelLayout.setHorizontalGroup(
            messageOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(messageOrderPanelLayout.createSequentialGroup()
                //.addContainerGap()
                .addGroup(messageOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(orderedCheckBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomCheckBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        messageOrderPanelLayout.setVerticalGroup(
            messageOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(messageOrderPanelLayout.createSequentialGroup()
                //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orderedCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(randomCheckBox))
        );
    }
}
