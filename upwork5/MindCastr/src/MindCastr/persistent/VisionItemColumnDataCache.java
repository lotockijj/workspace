/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.persistent;

import MindCastr.components.settings.SettingsConfig;
import MindCastr.components.settings.SettingsConfig.MessageOrderSettings;
import MindCastr.components.visionboard.VisionItem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ash
 */
public class VisionItemColumnDataCache implements IColumnDataIterator {
    
    private final List<String> visionItemStrings = new LinkedList<String>();
    private final List<VisionItem> visionItems = new LinkedList<VisionItem>();
    
    private static final int RESET_INDEX = -1;
    
    private int currentIndex = RESET_INDEX;
    private final Random rundomIndexGenerator;
    private final MessageOrderSettings messageOrderSettings;
    
    public VisionItemColumnDataCache() {
        messageOrderSettings = SettingsConfig.getInstance().getMessageOrderSettings();
        assert(messageOrderSettings != null);
        rundomIndexGenerator = new Random();
    }
    
    public void addItemToCache(VisionItem visionItem) {
        if (visionItem == null) {
            return;
        }
        synchronized(this) {
            visionItemStrings.add(visionItem.toString());
            visionItems.add(visionItem);
        }
    }
    
    public synchronized VisionItem removeItemFromCache(int index) {
        if (index < 0 || index >= visionItemStrings.size()) {
            return null;
        }
        visionItemStrings.remove(index);
        return visionItems.remove(index);
    }
    
    public synchronized List<String> getVisionItemStrings() {
        return new ArrayList<String>(visionItemStrings);
    }
    
    public synchronized List<VisionItem> getVisionItems() {
        return new ArrayList<VisionItem>(visionItems);
    }
    
    @Override
    public synchronized VisionItem getNextItem() {
        if(messageOrderSettings.isOrdered) {
            if(currentIndex + 1 < visionItems.size()) {
                return visionItems.get(++ currentIndex);
            } else {
                return null;
            }
        } else {
            currentIndex = RESET_INDEX;//do not do this each time
            int itemsCount = visionItems.size();
            if(itemsCount > 0) {
                int nextIndex = rundomIndexGenerator.nextInt(itemsCount);
                return visionItems.get(nextIndex);
            } else {
                return null;
            }
        }
    }
    
    @Override
    public void resetIteration() {
        currentIndex = RESET_INDEX;
    }
}
