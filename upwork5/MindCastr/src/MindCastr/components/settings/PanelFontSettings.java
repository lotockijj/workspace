package MindCastr.components.settings;

import MindCastr.components.settings.SettingsConfig.FontSettings;
import MindCastr.constants.Constants;
import MindCastr.dropdown.colorchooser.DropDownColorChooser;
import MindCastr.panels.MainWindow;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelFontSettings extends PanelTitled {
    
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.MIDDLE_PANEL_PREFERRED_WIDTH, (int) (0.18 * MainWindow.MAIN_PANEL_PREFFERED_SIZE.height));
    
    
    String[] envfonts;
    private JComboBox fontComboBox;
    private JComboBox fontSizeComboBox;
    
    protected JPanel colorChooserPanel;
    
    //private MySliderUI mm;
    
    protected JLabel fontLabel;
    
    protected PanelFontDisplayLabel panelDisplay;
    protected PanelFontTransparentSlider panelSlider;
    
    private final FontSettings fontSettings;
    


    
    
    public PanelFontSettings(PanelFontDisplayLabel panelDisplay, PanelFontTransparentSlider panelSlider) {
        super("Font", PREFFERED_SIZE, null, false);
        
       
        fontSettings = SettingsConfig.getInstance().getFontSettings();
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        envfonts = gEnv.getAvailableFontFamilyNames();
        //setOpaque(false);
        
        //this.fontDisplayLabel = fontDisplayLabel;
        this.panelDisplay = panelDisplay;
        this.panelSlider= panelSlider;
        this.fontLabel = new JLabel(panelDisplay.fontDisplayLabel.getText());
        initComponents();
        //setUpLayout();
        
        setLayout(new FlowLayout(0, 5, 0));
       
        add(fontComboBox);
        add(fontSizeComboBox);
        add(colorChooserPanel);
        
        //add(this.fontLabel);
        //setCustomLayout();
        
        
    }
    
    private void initComponents() {
        fontComboBox = new javax.swing.JComboBox(envfonts);
        fontComboBox.setFont(Constants.INNER_COMPONENT_FONT);
        fontComboBox.setForeground(Constants.TEXT_COLOR_DARK);
                      
        
        
        fontComboBox.setPreferredSize(new Dimension((int)(PREFFERED_SIZE.getWidth() * 0.55), 30));
        
        fontComboBox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontComboBoxActionPerformed();
            }
        });
        
        int height = fontComboBox.getPreferredSize().height;
        
        fontSizeComboBox = new javax.swing.JComboBox();
        fontSizeComboBox.setFont(Constants.INNER_COMPONENT_FONT);
        fontSizeComboBox.setForeground(Constants.TEXT_COLOR_DARK);
        //fontSizeComboBox.setBorder(new EmptyBorder(new Insets(5,5,0,0)));
        fontSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"}));
        fontSizeComboBox.setPreferredSize(new Dimension((int)(PREFFERED_SIZE.getWidth() * 0.22), 30));
        fontSizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeComboBoxActionPerformed();
            }
        });
       
        
        
       // colorChooserPanel = new DropDownColorChooser(colorChooserPanel);
        
        colorChooserPanel = new DropDownColorChooser(fontLabel);
        colorChooserPanel.setPreferredSize(new Dimension((int)(PREFFERED_SIZE.getWidth() * 0.09), 22));
 
        colorChooserPanel.addPropertyChangeListener(new PropertyChangeListener() {
                    
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                panelDisplay.fontDisplayLabel.setForeground(colorChooserPanel.getBackground());
            }
        });
    }       
        
     
    
    public final void initComponentValues() {
        fontComboBox.setSelectedItem(fontSettings.font);
        fontSizeComboBox.setSelectedItem(String.valueOf(fontSettings.fontSize));
        panelDisplay.fontDisplayLabel.setFont(new Font(fontSettings.font, Font.PLAIN, fontSettings.fontSize));
        colorChooserPanel.setBackground(fontSettings.color);
        panelDisplay.fontDisplayLabel.setForeground(fontSettings.color);
        
        panelSlider.transparencySlider.setValue(fontSettings.transparency);
        fontComboBoxActionPerformed();
        fontSizeComboBoxActionPerformed();
        
    }
    
    private void fontComboBoxActionPerformed() {                                             
        int selectedIndex = fontComboBox.getSelectedIndex();
        String selectedFontName = envfonts[selectedIndex];
        Font oldFont = panelDisplay.fontDisplayLabel.getFont();
        Font newFont = new Font(selectedFontName, oldFont.getStyle(), oldFont.getSize());
        panelDisplay.fontDisplayLabel.setFont(newFont);
        fontSettings.font = selectedFontName;
        
    }
    
    private void fontSizeComboBoxActionPerformed() {                                                 
        String fontSizeStr = (String)fontSizeComboBox.getSelectedItem();
        int fontSize = Integer.parseInt(fontSizeStr);
        Font oldFont = panelDisplay.fontDisplayLabel.getFont();
        Font newFont = new Font(oldFont.getFontName(), oldFont.getStyle(), fontSize);
        panelDisplay.fontDisplayLabel.setFont(newFont);
        //fontDisplayLabelPanel.setPreferredSize(new Dimension((int)PREFFERED_SIZE.getWidth(), (int) fontDisplayLabel.getHeight()));
        fontSettings.fontSize = fontSize;
    }
    
   
    
    
    
}
