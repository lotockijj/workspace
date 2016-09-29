package proxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {
	
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retriving = false;
	
	public ImageProxy(URL url){
		imageURL = url;
	}

	public int getIconWidth() {
		if(imageIcon != null){
			return imageIcon.getIconWidth();
		}
		return 800;
	}

	public int getIconHeight() {
		if(imageIcon != null){
			return imageIcon.getIconHeight();
		}
		return 600;
	}

	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if(imageIcon != null){
			imageIcon.paintIcon(c, g, x, y);
		} else { 
			g.drawString("Loading CD cover, please wait...", x+300, y+190);
			if(!retriving){
				retriving = true;
				retrievalThread = new Thread(new Runnable() {
					
					public void run() {
						try{
							imageIcon = new ImageIcon(imageURL, "CD cover");
							c.repaint();
						} catch(Exception e){
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}

}
