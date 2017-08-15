package MindCastr.components.settings;

import MindCastr.components.TransparentButton;
import MindCastr.components.settings.SettingsConfig.CategorySettings;
import MindCastr.panels.MainWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelCategories extends PanelTitled {
    
    private TransparentButton addButton;
    private TransparentButton editButton;
    private CustomButtonGroup btnGroup;

    public static final CategorySettings categorySettings = SettingsConfig.getInstance().getCategorySettings();
    //private Runnable editPerformer;
    
    public PanelCategories() {
        super("Select Categories", new Dimension(PanelSettings.LEFT_PANEL_PREFERRED_WIDTH, SettingsLeftPanel.CATEGORIES_PREFERRED_HIGHT));
    }
    
    @Override
    protected void initHeaderPanel(String title) {
        btnGroup = new CustomButtonGroup();
        super.initHeaderPanel(title);
        int buttonSize = headerPanel.getPreferredSize().height;
        
        //add/edit buttons
        addButton = new TransparentButton(.4f);
        //addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_ico.png")));
        addButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButton.changeTransparency(.4f);
                String categoryName = (String)JOptionPane.showInputDialog(null, "Category name", "Input new category name",
                                             JOptionPane.PLAIN_MESSAGE, null, null, null);
                if(categoryName == null) {
                    return;
                }
                categoryName = categoryName.trim();
                if(categoryName.isEmpty()) {
                    return;
                }
                final String catName = categoryName;
                PanelCategoryComponent category = new PanelCategoryComponent(mainPanel.getPreferredSize().width, categoryName, btnGroup);
                category.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                    //    btnGroup.setSelected(catName);
                    } else if (e.getClickCount() == 2) {
                    //    btnGroup.setSelected(catName);
                        performEditCategory();
                    }
                    
                }
            });
                categorySettings.categories.put(categoryName, category.categoryItems);
                category.setAlignmentX(Component.CENTER_ALIGNMENT);
                mainPanel.add(category);
                category.revalidate();
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButton.changeTransparency(1f);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButton.changeTransparency(.6f);
            }
        });
        editButton = new TransparentButton(.4f);
        //editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_ico.png")));
        editButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButton.changeTransparency(1f);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButton.changeTransparency(.4f);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                performEditCategory();   
            }
        });
        //add add/edit buttons to panel
        JPanel buttonPanel = new JPanel(new BorderLayout(0,1));
        buttonPanel.setPreferredSize(new Dimension(buttonSize*2, (int)headerPanel.getPreferredSize().getHeight()));
        buttonPanel.add(addButton, BorderLayout.WEST);
        buttonPanel.add(editButton, BorderLayout.EAST);
        headerPanel.add(buttonPanel, BorderLayout.EAST);
        //headerPanel.add(editButton);
    }

    public static List<String> getRemovedItems(List<String> originalOnes, List<String> newOnes) {
        List<String> result = new LinkedList<String>();
        List<String> newOnesCopy = new ArrayList<String>(newOnes);
        for (String originalOne : originalOnes) {
            boolean contained = newOnesCopy.remove(originalOne);
            if (!contained) {
                result.add(originalOne);
            }
        }
        return result;
    }

    public static List<String> getAddedItems(List<String> originalOnes, List<String> newOnes) {
        List<String> result = new LinkedList<String>();
        List<String> originalOnesCopy = new ArrayList<String>(originalOnes);
        for (String newOne : newOnes) {
            boolean contained = originalOnesCopy.remove(newOne);
            if (!contained) {
                result.add(newOne);
            }
        }
        return result;
    }
    
    public void performEditCategory() {
        MainWindow dialogOwnerFrame = MainWindow.getInstance();
        if (btnGroup.selectedCategory != null) {
            EditCategoryDialog editDialog = new EditCategoryDialog(dialogOwnerFrame, btnGroup.selectedCategory.categoryName, btnGroup.selectedCategory.categoryItems);
            List<String> subliminalTexts = editDialog.getSubliminalTexts();
            if (btnGroup.selectedCategory.isChecked()) {
                List<String> removedItems = getRemovedItems(btnGroup.selectedCategory.categoryItems, subliminalTexts);
                btnGroup.selectedCategory.removeTextItems(removedItems);
                List<String> addedItems = getAddedItems(btnGroup.selectedCategory.categoryItems, subliminalTexts);
                btnGroup.selectedCategory.addTextItems(addedItems);
            }
            btnGroup.selectedCategory.categoryItems.clear();
            btnGroup.selectedCategory.categoryItems.addAll(subliminalTexts);
            categorySettings.categories.put(btnGroup.selectedCategory.categoryName, btnGroup.selectedCategory.categoryItems);
        }
    }

    @Override
    protected void initMainPanel() {
        super.initMainPanel();
        boolean FirstCategory = true;
        for(Map.Entry<String, List<String>> cetegoryEntry : categorySettings.categories.entrySet()) {
            final String categoryName = cetegoryEntry.getKey();
            PanelCategoryComponent category = new PanelCategoryComponent(mainPanel.getPreferredSize().width, categoryName, cetegoryEntry.getValue(), categorySettings.selectedCategoryNames, btnGroup);
        
            mainPanel.add(category);
            
            if (FirstCategory)
                category.categoryButton.setSelected(true);
            FirstCategory = false;
            category.revalidate();
        }
    }
    
    public static class CustomButtonGroup extends ButtonGroup {
        
        public final Map<String, PanelCategoryComponent> categories = new TreeMap<String, PanelCategoryComponent>();
        public PanelCategoryComponent selectedCategory;
        
        public void addCategory(PanelCategoryComponent category) {
            categories.put(category.categoryName, category);
            if(selectedCategory == null) {
                selectedCategory = category;
            
            }
        }
        
        public void setSelected(String categoryName) {
            selectedCategory = categories.get(categoryName);
            assert(selectedCategory != null);
        }
    }
}
