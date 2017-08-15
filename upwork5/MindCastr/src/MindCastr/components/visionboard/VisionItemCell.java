package MindCastr.components.visionboard;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class VisionItemCell extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, MouseListener, MouseMotionListener {

    private final VisionBoardColumn visionBoardColumn;
    private VisionItemPanel renderPanel;
    private VisionItemPanel editPanel;
    private Object editorValue;
    
    private int mouseOnRow = Integer.MIN_VALUE;//some dummy initial value
    private int mouseOnColumn = Integer.MIN_VALUE;
    
    private boolean isButtonColumnEditor;

    public VisionItemCell(VisionBoardColumn visionBoardColumn) {
        this.visionBoardColumn = visionBoardColumn;
        TableColumnModel columnModel = visionBoardColumn.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(this);
        columnModel.getColumn(0).setCellEditor(this);
        visionBoardColumn.addMouseListener(this);
        visionBoardColumn.addMouseMotionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            editPanel = null;
        } else {
            editPanel = (VisionItemPanel)value;
        }

        this.editorValue = value;
        return editPanel;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            renderPanel = null;
        } else {
            renderPanel = (VisionItemPanel)value;
            if(mouseOnRow == row && mouseOnColumn == column) {
                renderPanel.mouseEntered();
            } else {
                renderPanel.mouseExited();
            }
        }

        return renderPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (visionBoardColumn.isEditing() && visionBoardColumn.getCellEditor() == this) {
            isButtonColumnEditor = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseOnRow = visionBoardColumn.rowAtPoint(e.getPoint());
        mouseOnColumn = visionBoardColumn.columnAtPoint(e.getPoint());
        if(mouseOnColumn == -1 /*out of this column*/) {
            mouseExited(e);
            if (isButtonColumnEditor && visionBoardColumn.isEditing()) {
                visionBoardColumn.getCellEditor().stopCellEditing();
            }
            return;
        }
        assert(mouseOnRow >= 0);
        DefaultTableModel model = (DefaultTableModel) visionBoardColumn.getModel();
        VisionItemPanel panel = (VisionItemPanel)model.getValueAt(mouseOnRow, mouseOnColumn);
        boolean shouldRemove = false;
        if (isButtonColumnEditor && visionBoardColumn.isEditing()) {
            shouldRemove = panel.isMouseOnBinButton();
            visionBoardColumn.getCellEditor().stopCellEditing();
        }
        if(shouldRemove) {
            visionBoardColumn.removeItem(mouseOnRow, true, true);
            PanelVisionBoard.getInstance().refreshMe();
        }
        
        isButtonColumnEditor = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        //remove bin from all cells in this table/column
        mouseOnRow = -1;
        mouseOnColumn = -1;
        visionBoardColumn.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseOnRow = visionBoardColumn.rowAtPoint(e.getPoint());
        mouseOnColumn = visionBoardColumn.columnAtPoint(e.getPoint());
        visionBoardColumn.repaint();//to fire table/cell rendering again (to show/not show bin button in correct place)
    }
}
