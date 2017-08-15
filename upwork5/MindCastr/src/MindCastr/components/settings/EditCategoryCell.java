package MindCastr.components.settings;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EditCategoryCell implements KeyListener {

    private final JTable targetTable;
    private boolean isSelectRow = true;
    private final Color selectionColor;
    
    public EditCategoryCell(final JTable targetTable) {
        this.targetTable = targetTable;
        //targetTable.setSelectionBackground(Color.red);
        targetTable.addKeyListener(this);
        selectionColor = targetTable.getSelectionBackground();
        //selectionColor = Color.red;
        
        targetTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(targetTable.getSelectedRow());
                if(!isSelectRow) {
                    //targetTable.setce
                    targetTable.setSelectionBackground(targetTable.getBackground());
                } else {
                    targetTable.setSelectionBackground(selectionColor);
                    isSelectRow = false;
                }
            }
        });
        
        targetTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isSelectRow = true;
            }
        });
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DELETE) {
            System.out.println("keyReleased");
            DefaultTableModel tableModel = (DefaultTableModel) targetTable.getModel();
            int rowCount = tableModel.getRowCount();

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int selectedRow = targetTable.getSelectedRow();
                int editedRow = 0;
                if (rowCount != 1) {
                    if (selectedRow == 0) {
                        editedRow = (rowCount - 1);
                    } else {
                        editedRow = (selectedRow - 1);
                    }
                }
                String editedValue = (String) tableModel.getValueAt(editedRow, 0);
                boolean isLastRow = (editedRow == rowCount - 1);
                if (isLastRow) {
                    int selectionRowIndex = 0;
                    if (!editedValue.isEmpty()) {
                        tableModel.addRow(new Object[]{""});
                        selectionRowIndex = (editedRow + 1);
                        System.out.println("before");
                        System.out.println("after");
                    }
                    isSelectRow = true;
                    if(selectionRowIndex == 0) {
                        targetTable.setSelectionBackground(Color.BLUE);
                    }
                    targetTable.setRowSelectionInterval(selectionRowIndex, selectionRowIndex);
                } else if (editedValue.isEmpty()) {
                    tableModel.removeRow(editedRow);
                } else {
                    
                    int selectionRowIndex = (editedRow + 1);
                    if(selectionRowIndex == rowCount - 1) {
                        targetTable.setSelectionBackground(Color.BLUE);
                    } else {
                        isSelectRow = true;
                        targetTable.setRowSelectionInterval(editedRow + 1, editedRow + 1);
                    }
                    
                }
            } else {
                int rowToDelete = targetTable.getSelectedRow();
                if (rowToDelete < 0) {
                    return;
                }
                if (rowToDelete != (rowCount - 1)) {
                    tableModel.removeRow(rowToDelete);
                    return;
                }
                String valueToDelete = (String) tableModel.getValueAt(rowToDelete, 0);
                if (rowToDelete == 0 && !valueToDelete.isEmpty()) {
                    tableModel.setValueAt("", 0, 0);
                }
                targetTable.getCellEditor().stopCellEditing();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
            isSelectRow = true;
        }
    }

}
