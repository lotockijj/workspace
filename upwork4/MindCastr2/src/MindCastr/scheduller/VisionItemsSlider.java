/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.scheduller;

import MindCastr.components.settings.SettingsConfig;
import MindCastr.components.settings.SettingsConfig.TimeSettings;
import MindCastr.components.visionboard.PanelVisionBoard;
import MindCastr.components.visionboard.VisionItem;
import MindCastr.message.Subliminal;
import MindCastr.persistent.VisionBoardDataIterator;

/**
 *
 * @author Ash
 */
public class VisionItemsSlider {
    
    private final SliderThread sliderThread;
    
    public VisionItemsSlider() {
        sliderThread = new SliderThread();
        sliderThread.start();
    }
    
    public void play() {
        sliderThread.play();
    }
    
    public void pause() {
        sliderThread.pause();
    }
    
    public void stop() {
        sliderThread.stopForExit();
    }
    
    private class SliderThread extends Thread {
        
        private final TimeSettings timeSettings = SettingsConfig.getInstance().getTimeSettings();
        private final VisionBoardDataIterator dataIterator = PanelVisionBoard.getInstance().dataIterator;
        private volatile boolean isPaused = true;
        private volatile boolean isStoped = false;
        //private final Object synchObj = new Object();
        
        public void play() {
            isPaused = false;
            synchronized(this) {
                notify();
            }
        }
        
        public void pause() {
            isPaused = true;
            synchronized(this) {
                notify();
            }
        }
        
        public void stopForExit() {
            isStoped = true;
            synchronized(this) {
                notify();
            }
        }
        
        @Override
        public void run() {
            Subliminal subliminal = new Subliminal();
            while(!isStoped) {
                long waitTime = timeSettings.displayEverySecondsValue * 1000;
                if(waitTime == 0) {
                    //if user typed 0 then wait 10 millisecond (0 will wait infinite time untill notified)
                    waitTime = 10;
                }
                waitTime = (isPaused ? 0 : timeSettings.displayEverySecondsValue * 1000);
                waitMilliseconds(waitTime);
                if(isPaused || isStoped) {
                    continue;
                }
                VisionItem itemToShow = dataIterator.getNextItem();
                long dispForMillis = timeSettings.displayForMillisecondsValue;
                if(itemToShow != null && dispForMillis != 0) {
                    //System.out.print("START: ");
                    //Utils.printMemoryInfo();
                    subliminal.setContent(itemToShow.content);
                    subliminal.setVisible(true);
                    waitMilliseconds(dispForMillis);
                    subliminal.setVisible(false);
                    subliminal.dispose();
                    //System.out.print("END: ");
                    //Utils.printMemoryInfo();
                    //System.out.println();
                }
            }
            subliminal.dispose();
        }
        
        private void waitMilliseconds(long milliseconds) {
            synchronized(this) {
                try {
                    wait(milliseconds);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }
    
}
