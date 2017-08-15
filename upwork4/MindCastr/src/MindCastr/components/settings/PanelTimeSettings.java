package MindCastr.components.settings;

import MindCastr.components.settings.SettingsConfig.TimeSettings;
import MindCastr.constants.Constants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class PanelTimeSettings extends PanelTitled {
 
    private JLabel displayEveryLabel;
    private JTextField displayEveryTextField;
    private JLabel displayEverySecondsLabel;
    
    private JLabel displayForLabel;
    private JFormattedTextField displayForTextField;
    private JLabel displayForMillisLabel;
    
    private final TimeSettings timeSettings;
    
    public PanelTimeSettings() {
        super("Time Settings", new Dimension(PanelSettings.LEFT_PANEL_PREFERRED_WIDTH, SettingsLeftPanel.TIME_SETTINGS_PREFERRED_HIGHT), null, false);
        timeSettings = SettingsConfig.getInstance().getTimeSettings();
        initComponents();
        setUpLayout();
        //setBorder(new EmptyBorder(new Insets(20, 20, 20, 0)));
    }

    private void initComponents() {
        displayEveryLabel = new JLabel("Display Every");
        displayEveryLabel.setFont(Constants.INNER_COMPONENT_FONT);
        displayEveryLabel.setForeground(Constants.TEXT_COLOR);
        displayEveryLabel.setPreferredSize(new Dimension(83, 17));
        
        AbstractFormatter formatter = null;
        try {
            formatter = new MaskFormatter("####");
        } catch (ParseException ex) {
            ex.printStackTrace();
            assert(false);
        }
        displayEveryTextField = new JTextField();
        displayEveryTextField.setFont(Constants.INNER_COMPONENT_FONT);
        displayEveryTextField.setPreferredSize(new Dimension(38, 17));
        displayEveryTextField.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_ENTER) {
                    return;
                }
                String text = displayEveryTextField.getText().replaceAll("\\s","");
                if(!text.isEmpty()) {
                    Integer val = null;
                    try {
                        val = Integer.valueOf(text);
                    } catch (Exception ex) {
                    }
                    if(val != null && val > 0) {
                        timeSettings.displayEverySecondsValue = val;
                    }
                    displayEveryTextField.setText(String.valueOf(timeSettings.displayEverySecondsValue));
                }
            }
        });
        
        displayEverySecondsLabel = new JLabel("Seconds");
        displayEverySecondsLabel.setFont(Constants.INNER_COMPONENT_FONT);
        displayEverySecondsLabel.setForeground(Constants.TEXT_COLOR_SECONDS);
        displayEverySecondsLabel.setPreferredSize(new Dimension(83, 17));
        
        displayForLabel = new JLabel("Display For");
        displayForLabel.setFont(Constants.INNER_COMPONENT_FONT);
        displayForLabel.setForeground(Constants.TEXT_COLOR);
        displayForLabel.setPreferredSize(new Dimension(83, 17));
        
        formatter = null;
        try {
            formatter = new MaskFormatter("####");
        } catch (ParseException ex) {
            ex.printStackTrace();
            assert(false);
        }
        displayForTextField = new JFormattedTextField(formatter);
        displayForTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
        displayForTextField.setFont(Constants.INNER_COMPONENT_FONT);
        displayForTextField.setPreferredSize(new Dimension(38, 17));
        displayForTextField.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_ENTER) {
                    return;
                }
                String text = displayForTextField.getText().replaceAll("\\s","");
                if(!text.isEmpty()) {
                    Long val = null;
                    try {
                        val = Long.valueOf(text);
                    } catch (Exception ex) {
                    }
                    if(val != null && val > 0) {
                        timeSettings.displayForMillisecondsValue = val;
                    }
                    //String inputVal = new String(new char[]{keyChar});
                    displayForTextField.setText(String.valueOf(timeSettings.displayForMillisecondsValue));
                }
            }
        });
        
        displayForMillisLabel = new JLabel("Milliseconds");
        displayForMillisLabel.setFont(Constants.INNER_COMPONENT_FONT);
        displayForMillisLabel.setForeground(Constants.TEXT_COLOR_SECONDS);
        displayForMillisLabel.setPreferredSize(new Dimension(83, 17));
    }
    
    public final void initComponentValues() {
        displayEveryTextField.setText(String.valueOf(timeSettings.displayEverySecondsValue));
        displayForTextField.setText(String.valueOf(timeSettings.displayForMillisecondsValue));
    }
    
    private void setUpLayout() {
        GroupLayout timeSettingsPanelLayout = new GroupLayout(mainPanel);
        setLayout(timeSettingsPanelLayout);
        
        timeSettingsPanelLayout.setHorizontalGroup(
            timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayForLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayEveryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayForTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayEveryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(displayEverySecondsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayForMillisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(5, Short.MAX_VALUE))
        );
        timeSettingsPanelLayout.setVerticalGroup(
            timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayEveryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayEveryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayEverySecondsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(timeSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(displayForTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(displayForMillisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(displayForLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(5, Short.MAX_VALUE))
        );
    }

}
