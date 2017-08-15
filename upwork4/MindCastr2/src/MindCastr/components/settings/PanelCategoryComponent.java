package MindCastr.components.settings;

import MindCastr.components.settings.PanelCategories.CustomButtonGroup;
import MindCastr.components.visionboard.PanelVisionBoard;

import java.awt.*;
import javax.swing.*;

import MindCastr.constants.Constants;
import MindCastr.panels.MainWindow;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PanelCategoryComponent extends JPanel {

    private JCheckBox checkBox;
    public final JCheckBox categoryButton;
    public final String categoryName;
    public final List<String> categoryItems;
    private final Set<String> selectedCategoryNames;
    private final CustomButtonGroup buttonGroup;

    public PanelCategoryComponent(int weight, final String categoryName, final CustomButtonGroup buttonGroup) {
        this(weight, categoryName, new ArrayList<String>(), new TreeSet<String>(), buttonGroup);
    }

    public PanelCategoryComponent(int weight, final String categoryName, List<String> categoryItems, Set<String> selectedCategoryNames, final CustomButtonGroup buttonGroup) {
        super();
        if (categoryName == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (categoryItems == null) {
            throw new IllegalArgumentException("categoryItems cannot be null.");
        }
        if (buttonGroup == null) {
            throw new IllegalArgumentException("buttonGroup cannot be null.");
        }
        //this.preferredSize = preferredSize;
        setPreferredSize(new Dimension(weight, 20));
        this.categoryName = categoryName;
        this.categoryItems = categoryItems;
        this.selectedCategoryNames = selectedCategoryNames;
        this.buttonGroup = buttonGroup;
        categoryButton = new JCheckBox() {
            @Override
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(this.getX() - 10, this.getY());
            }

            @Override
            public JToolTip createToolTip() {
                JToolTip tip = super.createToolTip();

                tip.setBackground(Color.YELLOW);
                tip.setFont(Constants.INNER_COMPONENT_FONT);
                return tip;
            }
        };
        categoryButton.setIcon(new ImageIcon(""));
        init(isChecked());
       
        
    }

    private void init(boolean isChecked) {
        buttonGroup.addCategory(this);
        checkBox = new JCheckBox();
        checkBox.setSelected(isChecked);
        
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    //performHighliting();
                    //buttonGroup.setSelected(categoryName);
                    //add items
                    selectedCategoryNames.add(categoryName);
                    addTextItems(categoryItems);
                } else {
                    //
                    //remove items
                    selectedCategoryNames.remove(categoryName);
                    removeTextItems(categoryItems);
                }
            
            }
        });
        buttonGroup.add(categoryButton);
        
        categoryButton.setBackground(Constants.NESTED_CONTENT_PANELS_COLOR);
        categoryButton.setFont(Constants.INNER_COMPONENT_FONT);
        categoryButton.setForeground(Constants.TEXT_COLOR);
        
        categoryButton.setText(categoryName);     
        categoryButton.setOpaque(false);
        categoryButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        categoryButton.setFocusPainted(false);

        // create a tooltip help text
        ToolTipManager.sharedInstance().setInitialDelay(0);
        Canvas c = new Canvas();
        int categoryWidth = c.getFontMetrics(Constants.INNER_COMPONENT_FONT).stringWidth(categoryButton.getText());
        if (categoryWidth > PanelSettings.LEFT_PANEL_PREFERRED_WIDTH - 3*Constants.SCROLLBAR_PREFERRED_WIDTH) {
            categoryButton.setToolTipText(categoryButton.getText());
        }

        categoryButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {               
                
                if (categoryButton.isSelected())
                {
                
                categoryButton.setOpaque(true);
                categoryButton.setBackground(Constants.CATEGORIES_COLOR);
                categoryButton.setForeground(Color.white);
               
                buttonGroup.setSelected(categoryButton.getText());
                for (String key : buttonGroup.categories.keySet()) {
                    if (buttonGroup.categories.get(key).categoryButton != categoryButton)
                    {
                    buttonGroup.categories.get(key).categoryButton.setForeground(Constants.TEXT_COLOR);
                    buttonGroup.categories.get(key).categoryButton.setOpaque(false);
                    buttonGroup.categories.get(key).categoryButton.setBackground(Color.white);
                   
                    }
                }
                }
            }
            
            
        });
          
       
        
        categoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //buttonGroup.setSelected(categoryName);
                
                if (e.getClickCount() == 2) {

                    MainWindow dialogOwnerFrame = MainWindow.getInstance();
                    if (buttonGroup.selectedCategory != null) {
                        EditCategoryDialog editDialog = new EditCategoryDialog(dialogOwnerFrame, buttonGroup.selectedCategory.categoryName, buttonGroup.selectedCategory.categoryItems);
                        List<String> subliminalTexts = editDialog.getSubliminalTexts();
                        if (buttonGroup.selectedCategory.isChecked()) {
                            List<String> removedItems = PanelCategories.getRemovedItems(buttonGroup.selectedCategory.categoryItems, subliminalTexts);
                            buttonGroup.selectedCategory.removeTextItems(removedItems);
                            List<String> addedItems = PanelCategories.getAddedItems(buttonGroup.selectedCategory.categoryItems, subliminalTexts);
                            buttonGroup.selectedCategory.addTextItems(addedItems);
                        }
                        buttonGroup.selectedCategory.categoryItems.clear();
                        buttonGroup.selectedCategory.categoryItems.addAll(subliminalTexts);
                        PanelCategories.categorySettings.categories.put(buttonGroup.selectedCategory.categoryName, buttonGroup.selectedCategory.categoryItems);
                    }
                }
            }
        });

        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        layout.putConstraint(SpringLayout.WEST, categoryButton, 0, SpringLayout.EAST, checkBox);
        add(checkBox);
        add(categoryButton);
    }

    

    public final boolean isChecked() {
        return selectedCategoryNames.contains(categoryName);
    }

    public void addTextItems(List<String> textItems) {
        PanelVisionBoard.getInstance().addTextItems(textItems);
    }

    public void removeTextItems(List<String> textItems) {
        PanelVisionBoard.getInstance().removeTextItems(textItems);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension prefSize = super.getPreferredSize();
        if (checkBox == null || categoryButton == null) {
            return prefSize;
        }
        Dimension chBxPrefSize = checkBox.getPreferredSize();
        Dimension togglePrefSize = categoryButton.getPreferredSize();
        int prefWeight = chBxPrefSize.width + togglePrefSize.width;
        if (prefWeight > prefSize.width) {
            prefSize = new Dimension(prefWeight, prefSize.height);
        }
        return prefSize;
    }

    public void selectCategory() {
       // toggleButton.setSelected(true);
       // buttonGroup.setSelected(categoryName);
    }

    public JToggleButton getToggleButton() {
        return categoryButton;
    }
    
    
    

    
}
