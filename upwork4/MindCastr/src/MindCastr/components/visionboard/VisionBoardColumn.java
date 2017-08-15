package MindCastr.components.visionboard;

import MindCastr.constants.Constants;
import MindCastr.persistent.VisionItemColumnDataPersister;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VisionBoardColumn extends JTable {
    
    //private int index;
    
    private static final int PREFERRED_WIDTH = PanelVisionBoard.CONTENT_PANEL_PREFERRED_SIZE.width / 3;
    
    public final VisionItemColumnDataPersister dataPersister;
    
    private final PanelVisionBoard targetPanel;
    
    public VisionBoardColumn(PanelVisionBoard targetPanel, int columnNumber) {
        setModel(new DefaultTableModel(0, 1));
        setTableHeader(null);
        this.setBackground(Constants.ZERO_COLOR);
        //setShowGrid(false);
        TableColumn column = getColumnModel().getColumn(0);
        column.setPreferredWidth(PREFERRED_WIDTH);
        
        dataPersister = new VisionItemColumnDataPersister(columnNumber);
        this.targetPanel = targetPanel;
        loadExistingItems();
        
    }
    
    private void loadExistingItems() {
        List<VisionItem> visionItems = dataPersister.getVisionItems();
        assert(visionItems != null);
        for(VisionItem visionItem : visionItems) {
            addItem(visionItem, false);
        }
        revalidate();
        repaint();
    }
    
    public void addItem(VisionItem visionItem) {
        addItem(visionItem, true);
    }
    
    private void addItem(VisionItem visionItem, boolean persistItem) {
        assert(visionItem != null);
        if(persistItem) {
            visionItem = dataPersister.addItem(visionItem);
        }
        VisionItemPanel panel = new VisionItemPanel(visionItem, this);
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(new Object[]{panel});
        setRowHeight(model.getRowCount() - 1, panel.getPreferredSize().height);
        revalidate();
        repaint();
    }
    
    public void removeItem(int index) {
        removeItem(index, true, true);
    }
    
    public void removeItem(int index, boolean requestRebalance, boolean removeImage) {
        assert(index >= 0);
        dataPersister.removeItem(index, removeImage);
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.removeRow(index);
        if(requestRebalance) {
            targetPanel.doBalance(this);
        }
        //targetPanel.contentComponent.repaint();
        //targetPanel.refreshMe();
        revalidate();
        repaint();
       // targetPanel.refreshMe();
        
    }

    public int getItemCount() {
        return dataPersister.size();
    }
    
    public List<VisionItem> getItems() {
        return dataPersister.getVisionItems();
    }
    
    public List<String> getItemStrings() {
        return dataPersister.getVisionItemStrings();
    }
    
    public int getItemsHeight() {
        int height = 0;
        List<VisionItem> visionItems = dataPersister.getVisionItems();
        for(VisionItem visionItem : visionItems) {
            height += visionItem.getPreferredSize().height;
        }
        return height;
    }
}
