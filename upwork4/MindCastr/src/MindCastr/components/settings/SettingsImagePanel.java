/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components.settings;

import MindCastr.image.AdsImageConfig;
import MindCastr.image.AdsImagePanel;
import java.awt.Dimension;


public class SettingsImagePanel extends AdsImagePanel {

    private static final Dimension PREFFERED_SIZE = new Dimension(PanelSettings.PREFERRED_SIZE.width, PanelSettings.MAIN_PANEL_HEIGHT);
    private static final int IMAGE_X = PanelSettings.LEFT_PANEL_PREFERRED_WIDTH + 30;
    private static final int IMAGE_Y = 265; 
    private static final int IMAGE_WIDTH = PREFFERED_SIZE.width - IMAGE_X - 40;
    private static final int IMAGE_HIGHT = PREFFERED_SIZE.height - IMAGE_Y;
    private static final String IMG_NAME = "ads_1.png";
    
    private static final AdsImageConfig config = 
        new AdsImageConfig(IMAGE_WIDTH, IMAGE_HIGHT, IMG_NAME, IMAGE_X, IMAGE_Y);

    public SettingsImagePanel(String imgUrl, final String linkUrl) {     
        super(imgUrl, linkUrl, config);
    }
    
    public void refresh(String imgUrl, final String linkUrl){
        buildPanel(imgUrl, linkUrl, config);
    }

}