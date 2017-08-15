package MindCastr.components.settings;

import MindCastr.components.TransparentButton;
import MindCastr.constants.Constants;
import MindCastr.panels.MainWindow;
import MindCastr.persistent.MouseDragHandler;
import MindCastr.utils.JsonReader;
import MindCastr.utils.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelSettings extends JPanel {
 
    public static final Dimension PREFERRED_SIZE = MainWindow.MAIN_PANEL_PREFFERED_SIZE;
    private static final Dimension BUTTON_PREFERRED_SIZE = new Dimension((int) (0.2 * PREFERRED_SIZE.width), (int) (0.08 * PREFERRED_SIZE.height));
    public static final int MAIN_PANEL_HEIGHT = PREFERRED_SIZE.height - BUTTON_PREFERRED_SIZE.height;
    public static final int LEFT_PANEL_PREFERRED_WIDTH = (int)(0.4 * PREFERRED_SIZE.width);
    public static final int MIDDLE_PANEL_PREFERRED_WIDTH = (int)(0.39 * PREFERRED_SIZE.width);
    public static final int RIGHT_PANEL_PREFERRED_WIDTH = (int)(0.21 * PREFERRED_SIZE.width);
    
    private TransparentButton defaultsButton;
    private TransparentButton doneButton;
    
    private SettingsLeftPanel settingsLeftPanel;
    private SettingsMiddlePanel settingsMiddlePanel;
    private SettingsRightPanel settingsRightPanel;
    private SettingsImagePanel settingsImagePanel;
    private JPanel cp;
    
    
    public PanelSettings(MouseDragHandler mouseDragHandler) {
        super();

        setOpaque(false);
        setBackground(Constants.MAIN_CONTENT_PANELS_COLOR);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, Constants.SCROLLBAR_PREFERRED_WIDTH));
       // cp = new JPanel();
        
        setPreferredSize(PREFERRED_SIZE);
        initComponents();
        initComponentValues();
        addMouseMotionListener(mouseDragHandler);
      //  JOptionPane.showMessageDialog(null, "hi");
     /*     Thread slide = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                   //  repaint();
                     settingsMiddlePanel.panelFont.panelFontDisplayLabel.fontDisplayLabel.setForeground(settingsMiddlePanel.panelFont.panelFontSettings.colorChooserPanel.getBackground());
                      try{
                Thread.sleep(200);		
            }catch(InterruptedException e){}
                    }
                }
                    
        });
        slide.start();*/
    }
    
    public void refreshMe()
    {
        this.getParent().repaint();
    }
    
    public SettingsImagePanel getSettingsImagePanel(){
        return settingsImagePanel;
    }
    
    private void initComponents() {
        JPanel buttonsPanel = getButtonsPanel();
        JPanel contentPanel = getContentPanel();
        
        setLayout(new BorderLayout(0, 0));
        add(buttonsPanel, BorderLayout.PAGE_START);
        add(contentPanel, BorderLayout.CENTER);             
    }
    
    private JPanel getButtonsPanel() {
        //JPanel buttonsPanel = new JPanel();
        //ImagePanel buttonsPanel = new ImagePanel(
        //new ImageIcon("").getImage());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(PREFERRED_SIZE.width, BUTTON_PREFERRED_SIZE.height));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.TRAILING, 3, 3);
        buttonsPanel.setLayout(flowLayout);
        buttonsPanel.setBackground(Constants.MAIN_PANEL_COLOR); 
        buttonsPanel.setOpaque(true);
        defaultsButton = new TransparentButton();
        defaultsButton.setPreferredSize(new Dimension(121, 34));
        defaultsButton.setContentAreaFilled(false);
        defaultsButton.setBorder(new EmptyBorder(new Insets(5, 0, 0, 3)));
        defaultsButton.setOpaque(true);
        defaultsButton.setFocusable(false);
        final Icon normalEffectDefaultIcon = Utils.getIcon("/Set To Default(Normal State).png", 115, 29);
        final Icon hoverEffectDefaultIcon = Utils.getIcon("/Set To Default(Hover Effect State).png", 115, 29);

        defaultsButton.setIcon(normalEffectDefaultIcon);
        defaultsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SettingsConfig.getInstance().setAndSaveDefaults();
                initComponentValues();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                defaultsButton.setIcon(hoverEffectDefaultIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                defaultsButton.setIcon(normalEffectDefaultIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                defaultsButton.changeTransparency(1f);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                defaultsButton.changeTransparency(.6f);
            }
        });

        doneButton = new TransparentButton();
        doneButton.setPreferredSize(new Dimension(81, 34));
        final Icon normalEffectDoneIcon = Utils.getIcon("/All Done Button(Normal State).png", 78, 29);
        final Icon hoverEffectDoneIcon = Utils.getIcon("/All Done Button(Hover Effect State).png", 78, 29);
        doneButton.setBorder(new EmptyBorder(new Insets(5, 0, 0, 3)));
        doneButton.setContentAreaFilled(false);
        doneButton.setOpaque(true);

        doneButton.setFocusable(false);
        doneButton.setIcon(normalEffectDoneIcon);
        doneButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SettingsConfig.getInstance().setAndSaveValues();
                MainWindow.getInstance().performSettingsButtonClick();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                doneButton.setIcon(hoverEffectDoneIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                doneButton.setIcon(normalEffectDoneIcon);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                doneButton.changeTransparency(1f);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                doneButton.changeTransparency(.6f);
            }
        });
        
        buttonsPanel.add(defaultsButton);
        buttonsPanel.add(doneButton);
          
        return buttonsPanel;
    }
    
    private void initComponentValues() {
        settingsLeftPanel.panelTimeSettings.initComponentValues();
        settingsLeftPanel.panelMessageLocation.initComponentValues();
        settingsMiddlePanel.panelFont.panelFontSettings.initComponentValues();
        settingsMiddlePanel.panelFont.panelFontSettings.panelSlider.ps = this;
        settingsRightPanel.panelMessageOrder.initComponentValues();        
    }
    
    private JPanel getContentPanel() {
        settingsLeftPanel = new SettingsLeftPanel();
        settingsLeftPanel.setBorder(new EmptyBorder(new Insets(5, 5, 0, 1)));
        settingsMiddlePanel = new SettingsMiddlePanel();
        settingsMiddlePanel.setBorder(new EmptyBorder(new Insets(5, 1, 0, 1)));
        settingsRightPanel = new SettingsRightPanel();
        settingsRightPanel.setBorder(new EmptyBorder(new Insets(5, 1, 0, 5)));
        
        String ads1img = null;
        String ads1url = null;
        try {
            JsonReader adsReader = JsonReader.getInstance();
            ads1img = adsReader.getAds1img();
            ads1url = adsReader.getAds1url();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        settingsImagePanel = new SettingsImagePanel(ads1img, ads1url);
        settingsImagePanel.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
            
        
        JPanel contentPanel = new JPanel();
        //ImagePanel contentPanel = new ImagePanel(
        //new ImageIcon("./Configuration/background.jpg").getImage());
        contentPanel.setPreferredSize(new Dimension(PREFERRED_SIZE.width, MAIN_PANEL_HEIGHT));
        contentPanel.setLayout(new BorderLayout(2, 0));
        contentPanel.add(settingsLeftPanel, BorderLayout.LINE_START);
        contentPanel.add(settingsMiddlePanel, BorderLayout.CENTER);
        contentPanel.add(settingsRightPanel, BorderLayout.LINE_END);
        contentPanel.add(settingsImagePanel, BorderLayout.EAST);
       
        contentPanel.setBorder(new EmptyBorder(0, 3, 0, 3));
        return contentPanel;
    }
    
}
