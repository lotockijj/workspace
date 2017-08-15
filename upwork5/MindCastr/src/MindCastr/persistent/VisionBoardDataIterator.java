/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.persistent;

import MindCastr.components.settings.SettingsConfig;
import MindCastr.components.settings.SettingsConfig.MessageOrderSettings;
import MindCastr.components.visionboard.VisionItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ash
 */
public class VisionBoardDataIterator {
    
    private final List<IColumnDataIterator> columnIterators;
    private int currentIteratorIndex = 0;

    public VisionBoardDataIterator(List<IColumnDataIterator> columnIterators) {
        assert(columnIterators != null && !columnIterators.isEmpty());
        this.columnIterators = Collections.unmodifiableList(columnIterators);
    }
    
    public VisionItem getNextItem() {
        VisionItem nextItem = getNextItemInternal();
        if(nextItem == null) {
            for(IColumnDataIterator columnDataIterator : columnIterators) {
                columnDataIterator.resetIteration();
            }
            currentIteratorIndex = 0;
            nextItem = getNextItemInternal();
        }
        return nextItem;
    }
    
    private VisionItem getNextItemInternal() {
        MessageOrderSettings messageOrderSettings = SettingsConfig.getInstance().getMessageOrderSettings();
        if(messageOrderSettings.isOrdered) {
            for(int i = 0; i < columnIterators.size(); i++) {
                int columnIndex = getColumnIndex();
                IColumnDataIterator columnDataIterator = columnIterators.get(columnIndex);
                VisionItem columnNextItem = columnDataIterator.getNextItem();
                if(columnNextItem != null) {
                    return columnNextItem;
                }
            }
        } else {
            List<IColumnDataIterator> columnIterators_ = new ArrayList<IColumnDataIterator>(columnIterators);
            Random rand = new Random();
            VisionItem columnNextItem = null;
            while(!columnIterators_.isEmpty() && columnNextItem == null) {
                IColumnDataIterator colDataIterator = columnIterators_.remove(rand.nextInt(columnIterators.size()));
                columnNextItem = colDataIterator.getNextItem();
            }
            return columnNextItem;
        }
        return null;
    }
    
    private int getColumnIndex() {
        if(currentIteratorIndex == columnIterators.size()) {
            currentIteratorIndex = 0;
        }
        return currentIteratorIndex++;
    }
}
