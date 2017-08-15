package MindCastr.components.visionboard;

import MindCastr.components.visionboard.VisionItemContent.ContentType;
import java.awt.Color;
//import com.sun.awt.AWTUtilities;
import javax.swing.JEditorPane;

public abstract class VisionItem extends JEditorPane {
    
    public final VisionItemContent content;
    
    public VisionItem(String subliminalContentStr) {
        if(subliminalContentStr == null) {
            throw new IllegalArgumentException("subliminalContentStr cannot be null.");
        }
        ContentType contentType = getContentTypeEnum();
        if(contentType == null) {
            throw new IllegalArgumentException("contentType cannot be null.");
        }
        content = new VisionItemContent(contentType, subliminalContentStr);
            
        //setBackground(Constants.VISION_ITEM_COLOR);
        setBackground(new Color(255, 255, 255, 255));
        
        //AWTUtilities.
        
        setEditable(false);
    }
    
    public abstract ContentType getContentTypeEnum();
    
    @Override
    public String toString() {
        return content.toString();
    }
    
}
