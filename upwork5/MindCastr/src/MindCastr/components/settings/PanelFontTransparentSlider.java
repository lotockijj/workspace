/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MindCastr.components.settings;



import MindCastr.components.TransparentLabel;
import MindCastr.constants.Constants;
import MindCastr.panels.MainWindow;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Hackintosh
 */
public class PanelFontTransparentSlider extends JPanel {
    
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.MIDDLE_PANEL_PREFERRED_WIDTH-10, (int) (0.08 * MainWindow.MAIN_PANEL_PREFFERED_SIZE.height));
    
 
    protected JSlider transparencySlider;
    
    protected TransparentLabel fontDisplayLabel;
    
    protected PanelSettings ps;
    
    private final SettingsConfig.FontSettings fontSettings;
    
    public PanelFontTransparentSlider() {
       // super("Transparency", PREFFERED_SIZE, null, false);
        //fontDisplayLabel.setOpaque(true);
       // add(fontDisplayLabel);
         fontSettings = SettingsConfig.getInstance().getFontSettings();
        setOpaque(false);
      //  this.mainPanel.setOpaque(false);
           
         JLabel transparencyLabel = new JLabel("Transparency");
        transparencyLabel.setBorder(new EmptyBorder(new Insets(5,5,0,0)));
        transparencyLabel.setFont(Constants.PANEL_TITLE_FONT_SETTINGS);
        
        transparencySlider = new JSlider();
        //mm = new MySliderUI(transparencySlider);
        transparencySlider.setUI ( new MySliderUI(transparencySlider));
        
        transparencySlider.setOpaque(false);
        transparencySlider.setBackground(Constants.ZERO_COLOR);
        transparencySlider.setForeground(Constants.ZERO_COLOR);
        
        
        transparencySlider.setMaximum(100);
        transparencySlider.setPaintTicks(true);
        transparencySlider.setPreferredSize(new Dimension((int)PREFFERED_SIZE.getWidth()-30, 30));
        transparencySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {               
                repaint();
                transparencySliderStateChanged();   
                fontSettings.transparency = transparencySlider.getValue();
            }
        });
        

        
        setLayout(new BorderLayout(0, 0));     
        add(transparencyLabel, BorderLayout.NORTH);
        add(transparencySlider, BorderLayout.SOUTH);
        
          
      }  

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
        if (ps != null) ps.refreshMe();
    }
    
    
        
    private void transparencySliderStateChanged() {                                                
        int sliderValue = transparencySlider.getValue();
        float transparencyFactor = sliderValue/100f;
        assert(fontDisplayLabel instanceof TransparentLabel);
        ((TransparentLabel)fontDisplayLabel).changeTransparency(transparencyFactor);
        //fontSettings.transparency = sliderValue;
    }
}
