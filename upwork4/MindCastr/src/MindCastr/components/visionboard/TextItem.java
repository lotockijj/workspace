package MindCastr.components.visionboard;

import MindCastr.components.visionboard.VisionItemContent.ContentType;
import MindCastr.constants.Constants;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class TextItem extends VisionItem {
    
    private static final int PREFERRED_WIDTH = PanelVisionBoard.CONTENT_PANEL_PREFERRED_SIZE.width / 3;
    
    public final VisionItemContent content;
    
    public TextItem(String text) {
        super(text);
        setText(text);
        setFont(Constants.INNER_COMPONENT_FONT);
        setSize(PREFERRED_WIDTH, Short.MAX_VALUE);
        Dimension preferredSize = getPreferredSize();
        //preferredSize.height += 6;
        preferredSize.width -=6;
        setPreferredSize(preferredSize);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1, Constants.MAIN_CONTENT_PANELS_COLOR));
        content = new VisionItemContent(ContentType.TEXT, text);
    }

    @Override
    public ContentType getContentTypeEnum() {
        return ContentType.TEXT;
    }
}
