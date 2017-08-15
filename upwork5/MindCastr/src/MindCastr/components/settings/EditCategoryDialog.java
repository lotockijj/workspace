package MindCastr.components.settings;

import MindCastr.components.CustomScrollBar;
import MindCastr.components.TransparentButton;
import MindCastr.constants.Constants;
import MindCastr.utils.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class EditCategoryDialog extends JDialog {
    
    private static final Dimension PREFERRED_SIZE = new Dimension(200, (int) (2 * Constants.MAIN_WIN_HEIGHT / 3));
    
    JTable jTable;
    private JButton doneButton;
    
    public EditCategoryDialog(JFrame owner, String categoryName, List<String> subliminalTexts) {
        super(owner, true);
        setUndecorated(true);
        assert(categoryName != null);
        JPanel contentPanel = getContentPanel(categoryName, subliminalTexts);
        getContentPane().add(contentPanel);
        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
        
    }
    
    private JPanel getContentPanel(String categoryName, List<String> subliminalTexts) {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        jPanel.setBackground(Constants.NESTED_CONTENT_PANELS_COLOR);
        jPanel.setLayout(new BorderLayout(2, 0));
        jPanel.setPreferredSize(PREFERRED_SIZE);
        
        JLabel titleLabel = new JLabel(categoryName, JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(new Insets(3,0,3,0)));
        titleLabel.setOpaque(false);
        titleLabel.setFont(Constants.PANEL_TITLE_FONT_SETTINGS);
        jPanel.add(titleLabel, BorderLayout.NORTH);
        
        jTable = new JTable();
        //table.setShowGrid(false);
        jTable.setShowHorizontalLines(false);
        jTable.setShowVerticalLines(false);
        final DefaultTableModel tableModel = new DefaultTableModel(0, 1);
        for(String subliminalText : subliminalTexts) {
            tableModel.addRow(new Object[]{subliminalText});
        }
        tableModel.addRow(new Object[]{""});//this is to allow user to add new rows
        
        jTable.setModel(tableModel);
        jTable.setTableHeader(null);
        TableColumnModel columnModel = jTable.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(new BorderLessFocusCellRenderer());
        int lastRowIndex = tableModel.getRowCount() - 1;
        jTable.changeSelection(lastRowIndex, 0, false, false);
        jTable.requestFocus();
        new EditCategoryCell(jTable);
//        jTable.addKeyListener(new KeyListener() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    int editingRow = jTable.getEditingRow();
//                    if(editingRow == tableModel.getRowCount() - 1) {
//                        tableModel.addRow(new Object[]{""});
//                    }
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {}
//
//            @Override
//            public void keyTyped(KeyEvent e) {}
//        });

        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBorder(new EmptyBorder(new Insets(1,3,1,3)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setUI(new CustomScrollBar(Color.LIGHT_GRAY));
        verticalScrollBar.setPreferredSize(new Dimension(Constants.SCROLLBAR_PREFERRED_WIDTH, verticalScrollBar.getPreferredSize().height));
        
        jPanel.add(scrollPane, BorderLayout.CENTER);
        
        /*defaultsButton = new TransparentButton();
        defaultsButton.setPreferredSize(new Dimension(121, 34));
        defaultsButton.setContentAreaFilled(false);
        defaultsButton.setBorder(new EmptyBorder(new Insets(5, 0, 0, 3)));
        defaultsButton.setOpaque(true);
        defaultsButton.setFocusable(false);
        final Icon normalEffectDefaultIcon = Utils.getIcon("/Set To Default(Normal State).png", 115, 29);
        final Icon hoverEffectDefaultIcon = Utils.getIcon("/Set To Default(Hover Effect State).png", 115, 29);

        defaultsButton.setIcon(normalEffectDefaultIcon);*/
        
        
        doneButton = new JButton("Done");
        doneButton.setBackground(Color.white);
        //doneButton.setPreferredSize(new Dimension(doneIcon.getIconWidth(), doneIcon.getIconHeight()));
        //getRootPane().setDefaultButton(doneButton);
        doneButton.setFocusable(false);
        doneButton.setContentAreaFilled(false);
        doneButton.setOpaque(false);
        doneButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(doneButton.getPreferredSize());
        panel.add(doneButton, BorderLayout.CENTER);
        jPanel.add(panel, BorderLayout.SOUTH);
        
        scrollPane.setPreferredSize(new Dimension(PREFERRED_SIZE.width, PREFERRED_SIZE.height - jPanel.getPreferredSize().height - doneButton.getPreferredSize().height));
        return jPanel;
    }
    
    public List<String> getSubliminalTexts() {
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        int rowCount = model.getRowCount() - 1/*since the last row is to allow user to add new row*/;
        List<String> result = new ArrayList<String>(rowCount);
        for(int i = 0; i < rowCount; i++) {
            Object value = model.getValueAt(i, 0);
            result.add(value.toString());
        }
        return result;
    }
    
    private static class BorderLessFocusCellRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value,
                final boolean isSelected, final boolean hasFocus, final int row, final int col) {

            final boolean showFocusedCellBorder = false; // change this to see the behavior change

            final Component c = super.getTableCellRendererComponent(table, value, isSelected,
                    showFocusedCellBorder && hasFocus, row, col);
            
            if (isSelected) {
                c.setBackground(new Color(189,191,186));
            } else {
                c.setBackground(Color.white);
            }
            
            return c;
        }
    }
    
}
