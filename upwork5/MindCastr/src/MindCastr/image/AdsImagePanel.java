/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.image;

import MindCastr.persistent.ImageUtil;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Alex
 */
public class AdsImagePanel extends ImagePanel {

    public AdsImagePanel(String imgUrl, final String linkUrl, AdsImageConfig config) {
        super();
        buildPanel(imgUrl, linkUrl, config);
    }

    public void  buildPanel(String imgUrl, final String linkUrl, AdsImageConfig config)
    {
      if(imgUrl != null && !imgUrl.isEmpty()){
        BufferedImage bufferedImage = ImageUtil.loadAndSaveImage(imgUrl, config.getImageName());
            if(bufferedImage != null){
                this.img = bufferedImage;
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                this.setBounds(config.getX(), config.getY(), config.getWidth() , config.getHight());

                if(linkUrl != null && !linkUrl.isEmpty()){
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                Desktop br = Desktop.getDesktop();
                                br.browse(new URI(linkUrl));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            } catch (URISyntaxException e1) {
                                throw new IllegalStateException(e1);
                            }
                        }
                    });
                }
            }
        }
    }
}
