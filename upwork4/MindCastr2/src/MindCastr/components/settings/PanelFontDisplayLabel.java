/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MindCastr.components.settings;



import MindCastr.components.TransparentLabel;
import MindCastr.panels.MainWindow;
import java.awt.Dimension;
import java.awt.FlowLayout;


/**
 *
 * @author Hackintosh
 */
public class PanelFontDisplayLabel extends PanelTitled {
    
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.MIDDLE_PANEL_PREFERRED_WIDTH-10, (int) (0.10 * MainWindow.MAIN_PANEL_PREFFERED_SIZE.height));
    
    public TransparentLabel fontDisplayLabel;

    public PanelFontDisplayLabel() {
        super(null, PREFFERED_SIZE, null, false);
        fontDisplayLabel = new TransparentLabel("Font Display", 1f);
        setOpaque(false);
        //fontDisplayLabel.setOpaque(true);
        setLayout(new FlowLayout(0,10, 0));
        add(fontDisplayLabel);
        //this.setVisible(true);
           }
    
}
