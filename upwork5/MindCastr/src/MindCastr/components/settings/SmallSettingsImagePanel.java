/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components.settings;

import MindCastr.constants.Constants;
import MindCastr.image.AdsImageConfig;
import MindCastr.image.AdsImagePanel;
import MindCastr.panels.MainWindow;
import java.awt.Dimension;
import java.awt.Image;


public class SmallSettingsImagePanel extends AdsImagePanel {

    private static final Dimension PREFFERED_SIZE = new Dimension(Constants.MAIN_WIN_WIDTH, MainWindow.PLAYBACK_PANEL_HEIGHT);
    private static final int IMAGE_X = 133;
    private static final int IMAGE_Y = 0; 
    private static final int IMAGE_WIDTH = 206;
    private static final int IMAGE_HIGHT = 52;
    private static final String IMG_NAME = "ads_2.png";
    private Image bufferImage;
    
    private static final AdsImageConfig config = 
            new AdsImageConfig(IMAGE_WIDTH, IMAGE_HIGHT, IMG_NAME, IMAGE_X, IMAGE_Y);

    public SmallSettingsImagePanel(String imgUrl, final String linkUrl) {     
       super(imgUrl, linkUrl, config);
    }
    
    public void refresh(String imgUrl, String linkUrl){
        buildPanel(imgUrl, linkUrl, config);
    }
    
    @Override
    public void hide() {
        if(img != null){
            bufferImage = img;
            img = null;
        }
    }
    
    @Override
    public void show() {
        if(bufferImage != null){
            img = bufferImage;
        }
    }

}