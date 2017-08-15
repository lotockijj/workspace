/*

THIS FILE HAS BEEN REPLACED BY PaneFont1.java

package MindCastr.components.settings;

import MindCastr.components.TransparentLabel;
import MindCastr.components.TransparentPanel;
import MindCastr.components.settings.SettingsConfig.FontSettings;
import MindCastr.constants.Constants;
import MindCastr.dropdown.colorchooser.DropDownColorChooser;
import MindCastr.panels.MainWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;


public class PanelFont extends PanelTitled {
    
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.MIDDLE_PANEL_PREFERRED_WIDTH, (int) (0.4 * MainWindow.MAIN_PANEL_PREFFERED_SIZE.height) + 10);
    
    String[] envfonts;
    private JComboBox fontComboBox;
    private JComboBox fontSizeComboBox;
    private JPanel colorChooserPanel;
    public JSlider transparencySlider;
    //private MySliderUI mm;
    
    private final FontSettings fontSettings;
    private TransparentLabel fontDisplayLabel;
    private JPanel transparencyPanel;
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    
    public PanelFont() {
        super(null, PREFFERED_SIZE, null, false);
        fontSettings = SettingsConfig.getInstance().getFontSettings();
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        envfonts = gEnv.getAvailableFontFamilyNames();
        setOpaque(false);
        initComponents();
        //setUpLayout();
        makeLayout();
        
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
        fontSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"}));
        fontSizeComboBox.setPreferredSize(new Dimension((int)(PREFFERED_SIZE.getWidth() * 0.22), 30));
        fontSizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeComboBoxActionPerformed();
            }
        });
        fontDisplayLabel = new TransparentLabel("Font Display", 0f);
        //fontDisplayLabel.setOpaque(true);
        //fontDisplayLabel.setBackground(Color.white);
        
        
        colorChooserPanel = new DropDownColorChooser(fontDisplayLabel);
        colorChooserPanel.setPreferredSize(new Dimension((int)(PREFFERED_SIZE.getWidth() * 0.09), 22));

        transparencyPanel = new JPanel(new BorderLayout(5,2));
        transparencyPanel.setBackground(Color.white);
        JLabel transparencyLabel = new JLabel("Transparency");
        transparencyLabel.setBorder(new EmptyBorder(new Insets(5,5,0,0)));
        transparencyLabel.setFont(Constants.PANEL_TITLE_FONT_SETTINGS);
        transparencyPanel.add(transparencyLabel, BorderLayout.NORTH);
        transparencySlider = new JSlider();
        //mm = new MySliderUI(transparencySlider);
        transparencySlider.setUI ( new MySliderUI(transparencySlider));
        transparencyPanel.add(transparencySlider, BorderLayout.SOUTH);
        transparencySlider.setOpaque(false);
        transparencySlider.setMaximum(100);
        transparencySlider.setPaintTicks(true);
        transparencySlider.setPreferredSize(new Dimension((int)PREFFERED_SIZE.getWidth()-30, 30));
        transparencySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                transparencySliderStateChanged();
            }
        });
    }
    
    public final void initComponentValues() {
        fontComboBox.setSelectedItem(fontSettings.font);
        fontSizeComboBox.setSelectedItem(String.valueOf(fontSettings.fontSize));
        fontDisplayLabel.setFont(new Font(fontSettings.font, Font.PLAIN, fontSettings.fontSize));
        colorChooserPanel.setBackground(fontSettings.color);
        transparencySlider.setValue(fontSettings.transparency);
        fontSizeComboBoxActionPerformed();
        fontSizeComboBoxActionPerformed();
        transparencySliderStateChanged();
    }
    
    private void fontComboBoxActionPerformed() {                                             
        int selectedIndex = fontComboBox.getSelectedIndex();
        String selectedFontName = envfonts[selectedIndex];
        Font oldFont = fontDisplayLabel.getFont();
        Font newFont = new Font(selectedFontName, oldFont.getStyle(), oldFont.getSize());
        fontDisplayLabel.setFont(newFont);
        fontSettings.font = selectedFontName;
    }
    
    private void fontSizeComboBoxActionPerformed() {                                                 
        String fontSizeStr = (String)fontSizeComboBox.getSelectedItem();
        int fontSize = Integer.parseInt(fontSizeStr);
        Font oldFont = fontDisplayLabel.getFont();
        Font newFont = new Font(oldFont.getFontName(), oldFont.getStyle(), fontSize);
        fontDisplayLabel.setFont(newFont);
        //fontDisplayLabelPanel.setPreferredSize(new Dimension((int)PREFFERED_SIZE.getWidth(), (int) fontDisplayLabel.getHeight()));
        fontSettings.fontSize = fontSize;
    }
    
    private void transparencySliderStateChanged() {                                                
        int sliderValue = transparencySlider.getValue();
        float transparencyFactor = sliderValue/100f;
        assert(fontDisplayLabel instanceof TransparentLabel);
        ((TransparentLabel)fontDisplayLabel).changeTransparency(transparencyFactor);
        fontSettings.transparency = sliderValue;
    }
    
    private void makeLayout() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        
        
        c.weightx = 0.2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(fontComboBox, c);
        
        c.gridx = 1;
        mainPanel.add(fontSizeComboBox, c);
        
        c.gridx = 2;
        
        mainPanel.add(colorChooserPanel, c);
        
        
        
        c.gridy = 1;
        c.gridx = 0;
        mainPanel.add(fontDisplayLabel, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        mainPanel.add(transparencyPanel, c);

        
    }
    
    private void setCustomLayout() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
        setLayout(new BorderLayout(0, 0));       
        
        //add(panel1, BorderLayout.CENTER);
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBorder(new EmptyBorder(new Insets(5,5,0,0)));
        fontLabel.setFont(Constants.PANEL_TITLE_FONT_SETTINGS);
        
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.SOUTH);
        
        //panel1.setBorder(new EmptyBorder(new Insets(50, 0, 0, 0)));
        //panel1.setVisible(true);
        //panel1.setOpaque(false);
        //panel1.setPreferredSize( new Dimension( PREFFERED_SIZE.width, 50 ) );
        
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.add(fontLabel, BorderLayout.NORTH);
        panel2.add(fontComboBox, BorderLayout.WEST);       
        panel2.add(fontSizeComboBox, BorderLayout.CENTER);
        panel2.add(colorChooserPanel, BorderLayout.EAST);
        panel2.setOpaque(true);
        panel2.setVisible(true);
        //panel2.setBackground(Constants.MAIN_PANEL_COLOR);
        //panel2.add(fontDisplayLabel);
        panel3.add(transparencyPanel);
        
    }
    
    private void setUpLayout() {
        GroupLayout fontPanelLayout = new GroupLayout(mainPanel);
        setLayout(fontPanelLayout);
        fontPanelLayout.setHorizontalGroup(
            fontPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(fontPanelLayout.createSequentialGroup()
                .addComponent(fontComboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontSizeComboBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorChooserPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(fontDisplayLabel, GroupLayout.PREFERRED_SIZE, this.getPreferredSize().width, GroupLayout.PREFERRED_SIZE)
            .addComponent(transparencySlider, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );
        fontPanelLayout.setVerticalGroup(
            fontPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fontPanelLayout.createSequentialGroup()
                .addGroup(fontPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fontComboBox, GroupLayout.Alignment.TRAILING)
                    .addComponent(colorChooserPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fontSizeComboBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontDisplayLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transparencySlider, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fontPanelLayout.setAutoCreateContainerGaps(true);
        fontPanelLayout.setAutoCreateGaps(true);
    }
    
}
*/