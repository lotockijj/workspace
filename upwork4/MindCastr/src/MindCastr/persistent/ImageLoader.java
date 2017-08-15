/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.persistent;

import MindCastr.components.visionboard.ImageItem;
import java.awt.image.BufferedImage;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Ash
 */
public class ImageLoader {
    
    private static int missedCount = 0;
    
    private ThreadPoolExecutor executor;
    
    private static ImageLoader instance;
    
    public static ImageLoader getLoader() {
        if(instance == null) {
            synchronized(ImageLoader.class) {
                if(instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }
    
    private ImageLoader() {
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(500);
        RejectedExecutionHandler rejExecutionHandler = new MyRejectedExecutionHandelerImpl();
        executor = new ThreadPoolExecutor(5, 15, 1, TimeUnit.SECONDS, worksQueue, rejExecutionHandler);
        executor.allowCoreThreadTimeOut(true);
    }
    
    public void addImageToCopy(String imageUrl, ImageItem imageItem) {
        executor.execute(new LoadWorkItem(imageUrl, imageItem));
    }
    
    private class MyRejectedExecutionHandelerImpl implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
            assert(runnable instanceof LoadWorkItem);
            LoadWorkItem workItem = (LoadWorkItem)runnable;
            if(workItem.retryCount >= 15) {
                System.out.println("FINELLY REJECTED ITEMS COUNT = " + (++missedCount));
                return;
            }
            workItem.retryCount ++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                //do nothing
            }
            executor.execute(runnable);
        }
    }

    public class LoadWorkItem implements Runnable {

        private String imageUrl;
        private ImageItem imageItem;
        private int retryCount = 0;
        
        public LoadWorkItem(String imageUrl, ImageItem imageItem) {
            this.imageUrl = imageUrl;
            this.imageItem = imageItem;
        }

        @Override
        public void run() {
           // JOptionPane.showMessageDialog(null, imageUrl);
            BufferedImage loadImage = ImageUtil.loadImage(imageUrl);   
            imageItem.changeImage(loadImage);
        }
        
        @Override
        public String toString() {
            return imageUrl;
        }
    }
}
