/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MindCastr.components.settings;


import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Hackintosh
 */
public class PanelFont1 extends JPanel {
    
     
    
    public final PanelFontSettings panelFontSettings;
    public final PanelFontDisplayLabel panelFontDisplayLabel;
    public final PanelFontTransparentSlider panelFontTransparentSlider;
  

    
    
    public PanelFont1() {
        setLayout(new BorderLayout(0, 0));
        setBackground(Constants.ZERO_COLOR);
        setOpaque(false);
        
  
        
        
        panelFontDisplayLabel = new PanelFontDisplayLabel();
        panelFontTransparentSlider = new PanelFontTransparentSlider();
        panelFontSettings = new PanelFontSettings(panelFontDisplayLabel, panelFontTransparentSlider);
        
        
        add(panelFontSettings, BorderLayout.NORTH);
        add(panelFontTransparentSlider, BorderLayout.SOUTH);
        add(panelFontDisplayLabel, BorderLayout.CENTER);
                       
        panelFontTransparentSlider.fontDisplayLabel = panelFontDisplayLabel.fontDisplayLabel;
                
       

    }
    
}
