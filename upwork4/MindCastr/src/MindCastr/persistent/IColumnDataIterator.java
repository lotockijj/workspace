/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.persistent;

import MindCastr.components.visionboard.VisionItem;

/**
 *
 * @author Ash
 */
public interface IColumnDataIterator {
    
    public VisionItem getNextItem();
    
    public void resetIteration();
}
