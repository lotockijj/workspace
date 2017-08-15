package MindCastr.components.visionboard;

import MindCastr.components.CustomScrollBar;
import MindCastr.constants.Constants;
import MindCastr.panels.MainWindow;
import MindCastr.persistent.MouseDragHandler;
import MindCastr.persistent.IColumnDataIterator;
import MindCastr.persistent.VisionBoardDataIterator;
import MindCastr.utils.Utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelVisionBoard extends JPanel {

    public List<VisionBoardColumn> vbColumns;
    public VisionBoardDataIterator dataIterator;
    public static final Dimension PREFERRED_SIZE = MainWindow.MAIN_PANEL_PREFFERED_SIZE;
    public static final Dimension CONTENT_PANEL_PREFERRED_SIZE = new Dimension(PREFERRED_SIZE.width -
            Constants.SCROLLBAR_PREFERRED_WIDTH - Constants.LEFT_PANEL_WIDTH
            , PREFERRED_SIZE.height - ItemSubmitPanel.PREFFERED_SIZE.height);
    private final ItemSubmitPanel itemSubmitPanel;
    private JScrollBar verticalScrollBar;
    public JScrollPane contentComponent;
    public JPanel guidePanel;
    private JScrollPane guideComponent;
    private JComponent usageComponent;
    private static PanelVisionBoard instance;
    private String tutorialUrl;
    private static final int BORDER_SIZE = 10;

    public static PanelVisionBoard getInstance() {
        return instance;
    }

    public static PanelVisionBoard createInstance(MouseDragHandler mouseDragHandler) {
        synchronized (PanelVisionBoard.class) {
            if (instance == null) {
                instance = new PanelVisionBoard(mouseDragHandler);
            }
        }
        return instance;
    }

    private PanelVisionBoard(MouseDragHandler mouseDragHandler) {
        setTutorialUrl(Constants.TUTORIAL_URL);
        setPreferredSize(PREFERRED_SIZE);
        setLayout(new BorderLayout());

        setBackground(Constants.ZERO_COLOR);
        setOpaque(false);

        itemSubmitPanel = new ItemSubmitPanel(this);

        add(itemSubmitPanel, BorderLayout.PAGE_START);
        initContentComponent(mouseDragHandler);
        usageComponent = UsageComponentUtil.createUsageComponent(mouseDragHandler, contentComponent);

        if (usageComponent != null) {
            add(usageComponent, BorderLayout.CENTER);
        } else {
            assert (contentComponent != null);
            add(contentComponent, BorderLayout.CENTER);
        }
    }

    private void initContentComponent(MouseDragHandler mouseDragHandler) {
        JPanel contentPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                int maxHeight = 0;
                for (VisionBoardColumn vbColumn : vbColumns) {
                    if (maxHeight < vbColumn.getPreferredSize().height) {
                        maxHeight = vbColumn.getPreferredSize().height;
                    }
                }
                return new Dimension(vbColumns.get(0).getPreferredSize().width, maxHeight + 15 /*why ???*/);
            }
        };

        Dimension scrollPanePrefSize = new Dimension(PREFERRED_SIZE.width, PREFERRED_SIZE.height - ItemSubmitPanel.PREFFERED_SIZE.height);

        guidePanel = new JPanel();
        guidePanel.setLayout(new BorderLayout());

        guidePanel.setBorder(new EmptyBorder(new Insets(10, 10, 20, 10)));
        guidePanel.setPreferredSize(CONTENT_PANEL_PREFERRED_SIZE);
        Dimension guideComponentsDimension = new Dimension(PREFERRED_SIZE.width - 20, 70);
        JPanel upperGuide = new JPanel(new BorderLayout(0, 20));
        {
            upperGuide.setPreferredSize(guideComponentsDimension);
            upperGuide.setBackground(Constants.MAIN_PANEL_COLOR);
            upperGuide.setLayout(new BoxLayout(upperGuide, BoxLayout.Y_AXIS));
            JLabel upperImageLabel = new JLabel(Utils.getIcon("/Arrow Pointing Up.png", 28));
            upperImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel upperTextLabel = new JLabel(Constants.UPPER_GUIDE_TEXT_LABEL);
            upperTextLabel.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
            upperTextLabel.setForeground(Constants.GUIDE_TEXT_LABELS_COLOR);
            upperTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            upperGuide.add(upperImageLabel);
            upperGuide.add(Box.createRigidArea(new Dimension(0,7)));
            upperGuide.add(upperTextLabel);
        }
        guidePanel.add(upperGuide, BorderLayout.NORTH);


        JPanel lowerGuide = new JPanel(new BorderLayout(0,20));
        {
            lowerGuide.setPreferredSize(guideComponentsDimension);
            lowerGuide.setBackground(Constants.MAIN_PANEL_COLOR);
            lowerGuide.setLayout(new BoxLayout(lowerGuide, BoxLayout.Y_AXIS));
            JLabel lowerImageLabel = new JLabel(Utils.getIcon("/Arrow Pointing Down.png", 28));
            lowerImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel lowerTextLabel = new JLabel(Constants.LOWER_GUIDE_TEXT_LABEL);
            lowerTextLabel.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
            lowerTextLabel.setForeground(Constants.GUIDE_TEXT_LABELS_COLOR);
            lowerTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            lowerGuide.add(lowerTextLabel);
            lowerGuide.add(Box.createRigidArea(new Dimension(0,7)));
            lowerGuide.add(lowerImageLabel);
        }
        guidePanel.add(lowerGuide, BorderLayout.SOUTH);
        JPanel demoVideo = new JPanel();
        {
            demoVideo.setPreferredSize(guideComponentsDimension);
            demoVideo.setLayout(new BoxLayout(demoVideo, BoxLayout.X_AXIS));
            JLabel textTutorial = new JLabel(Constants.TUTORIAL_TEXT_LABEL);
            textTutorial.setForeground(Constants.TUTORIAL_LABELS_COLOR);
            textTutorial.setFont(Constants.TUTORIAL_FONT);
            textTutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
            textTutorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
            watchTutorial(textTutorial);
            JButton playTutorial = new JButton();
            playTutorial.setBorderPainted(false);
            playTutorial.setContentAreaFilled(false);
            playTutorial.setIcon(Utils.getIcon("/btn_playtutorial_normal.png", 28));
            playTutorial.setRolloverIcon(Utils.getIcon("/btn_playtutorial_hover.png", 28));
            playTutorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
            playTutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
            watchTutorial(playTutorial);
            demoVideo.add(Box.createRigidArea(new Dimension(120,0)));
            demoVideo.add(textTutorial);
            demoVideo.add(playTutorial);
        }

        guidePanel.add(demoVideo, BorderLayout.CENTER);
        guidePanel.addMouseMotionListener(mouseDragHandler);
        guidePanel.setBackground(Constants.MAIN_PANEL_COLOR);
        guideComponent = new JScrollPane(guidePanel);
        guideComponent.getViewport().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                guideComponent.revalidate();
                guideComponent.repaint();
                refreshMe();

            }
        });
        guideComponent.setPreferredSize(scrollPanePrefSize);
        guideComponent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        guideComponent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        guideComponent.setOpaque(false);
        guideComponent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, Constants.SCROLLBAR_PREFERRED_WIDTH));



        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Constants.ZERO_COLOR);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_START;


        contentComponent = new JScrollPane(contentPanel);
        contentComponent.getViewport().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                contentComponent.revalidate();
                contentComponent.repaint();
                refreshMe();

            }
        });
        contentComponent.setPreferredSize(scrollPanePrefSize);
        contentComponent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//VERTICAL_SCROLLBAR_ALWAYS);
        contentComponent.setBackground(Constants.ZERO_COLOR);
        contentComponent.getViewport().getView().setBackground(Constants.MAIN_PANEL_COLOR);
        contentComponent.setBorder(null);
        contentComponent.setViewportBorder(BorderFactory.createLineBorder(Constants.MAIN_PANEL_COLOR, BORDER_SIZE));

        verticalScrollBar = contentComponent.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setUI(new CustomScrollBar(Color.WHITE, Color.LIGHT_GRAY));
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));
        verticalScrollBar.setPreferredSize(new Dimension(Constants.SCROLLBAR_PREFERRED_WIDTH, verticalScrollBar.getPreferredSize().height));

        contentPanel.setPreferredSize(CONTENT_PANEL_PREFERRED_SIZE);

        List<IColumnDataIterator> colDataIterators = new ArrayList<IColumnDataIterator>(3);

        vbColumns = new ArrayList<VisionBoardColumn>(3);
        VisionBoardColumn oneColumn = new VisionBoardColumn(this, 0);
        colDataIterators.add(oneColumn.dataPersister.itemDataCache);
        new VisionItemCell(oneColumn);
        c.gridx = 0;
        contentPanel.add(oneColumn, c);
        vbColumns.add(oneColumn);

        oneColumn = new VisionBoardColumn(this, 1);
        colDataIterators.add(oneColumn.dataPersister.itemDataCache);
        new VisionItemCell(oneColumn);
        c.gridx = 1;
        contentPanel.add(oneColumn, c);
        vbColumns.add(oneColumn);

        oneColumn = new VisionBoardColumn(this, 2);
        colDataIterators.add(oneColumn.dataPersister.itemDataCache);
        new VisionItemCell(oneColumn);
        c.gridx = 2;
        contentPanel.add(oneColumn, c);
        vbColumns.add(oneColumn);

        dataIterator = new VisionBoardDataIterator(colDataIterators);

        contentPanel.addMouseMotionListener(mouseDragHandler);


    }

    public void addItem(VisionItem item) {
        if (usageComponent != null) {
            remove(usageComponent);
            usageComponent = null;
            add(contentComponent, BorderLayout.CENTER);
            UsageComponentUtil.deleteLinkFileContent();
            revalidate();
        }
        VisionBoardColumn columnWithLeastSize = null;
        for (VisionBoardColumn col : vbColumns) {
            if (columnWithLeastSize == null) {
                columnWithLeastSize = col;
            } else if (col.getItemsHeight() < columnWithLeastSize.getItemsHeight()) {
                columnWithLeastSize = col;
            }
        }
        assert (columnWithLeastSize != null);
        columnWithLeastSize.addItem(item);
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
    }

    public int getItemsNumber() {
        int count = 0;
        for (VisionBoardColumn col : vbColumns) {
            count += col.getItemCount();
        }
        return count;
    }

    public void addTextItems(Collection<String> itemStrings) {
        assert (itemStrings != null);
        for (String itemString : itemStrings) {
            addTextItem(itemString);
        }
    }

    private void addTextItem(String itemString) {
        assert (itemString != null);
        VisionItem item = new TextItem(itemString);
        addItem(item);
    }

    public void removeTextItems(Collection<String> itemStrings) {
        assert (itemStrings != null);
        for (String itemString : itemStrings) {
            removeTextItem(itemString);
        }

    }

    private void removeTextItem(String itemString) {
        assert (itemString != null);
        for (VisionBoardColumn vbColumn : vbColumns) {
            List<String> visionItemStrings = vbColumn.dataPersister.getVisionItemStrings();
            int index = visionItemStrings.indexOf(VisionItemContent.ContentType.TEXT.prefixExtension + itemString);
            if (index != -1/*if -1 then does not exist*/) {
                vbColumn.removeItem(index);
                return;
            }
        }

    }

    public void doBalance(VisionBoardColumn baseColumn) {
        boolean balancingDone;
        do {
            balancingDone = doBalanceInternal(baseColumn);
        } while (balancingDone);
    }

    private boolean doBalanceInternal(VisionBoardColumn baseColumn) {
        VisionBoardColumn columnWithHighestSize = null;
        for (VisionBoardColumn col : vbColumns) {
            if (columnWithHighestSize == null) {
                columnWithHighestSize = col;
            } else if (col.getItemsHeight() > columnWithHighestSize.getItemsHeight()) {
                columnWithHighestSize = col;
            }
        }
        assert (columnWithHighestSize != null);
        if (columnWithHighestSize == baseColumn) {
            //no need to do rebalance
            return false;
        }

        int itemToMove = -1;
        int baseColumnSize = baseColumn.getItemsHeight();
        int highestColumnSize = columnWithHighestSize.getItemsHeight();
        int sizeDifference = highestColumnSize - baseColumnSize;
        assert (sizeDifference > 0);

        List<VisionItem> items = columnWithHighestSize.getItems();
        for (int i = items.size() - 1; i >= 0; i--/*try to move from the last elements, not from root*/) {
            VisionItem item = items.get(i);
            int itemHeight = item.getPreferredSize().height;
            int highestSizeIfMove = highestColumnSize - itemHeight;
            int baseSizeIfMove = baseColumnSize + itemHeight;
            int sizeDifferenceIfMove = Math.abs(baseSizeIfMove - highestSizeIfMove);
            if (sizeDifferenceIfMove < sizeDifference) {
                sizeDifference = sizeDifferenceIfMove;
                itemToMove = i;
            }
        }

        if (itemToMove == -1) {
            return false;
        }
        baseColumn.addItem(items.get(itemToMove));
        columnWithHighestSize.removeItem(itemToMove, false, false);
        return true;
    }

    public void setGuideOn(boolean switchOn) {
        if (switchOn) {
            remove(contentComponent);
            add(guideComponent, BorderLayout.CENTER);
            revalidate();
            repaint();
        } else {
            remove(guideComponent);
            add(contentComponent, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }

    public void refreshMe()
    {
        if (this.getParent() != null)
            this.getParent().repaint();
            this.getRootPane().repaint();
    }

    public void setTutorialUrl(String url){
        if(tutorialUrl == null || tutorialUrl.isEmpty()){
          tutorialUrl = url;
        }
    }
    
    private void watchTutorial (final Component tutorial){
        tutorial.addMouseListener(new MouseAdapter() {
            Font original;
                @Override
                public void mouseClicked(MouseEvent evt) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        try {
                            desktop.browse(new URI(tutorialUrl));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (tutorial instanceof JLabel){
                        original = tutorial.getFont();
                        Map attributes = original.getAttributes();
                        attributes.put(TextAttribute.UNDERLINE, 
                                TextAttribute.UNDERLINE_ON);
                        tutorial.setFont(original.deriveFont(attributes));
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (tutorial instanceof JLabel){
                        tutorial.setFont(original);
                    }
                }
            });
    }
}
