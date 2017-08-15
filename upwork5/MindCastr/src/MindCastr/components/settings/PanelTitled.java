package MindCastr.components.settings;

import MindCastr.components.CustomScrollBar;
import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelTitled extends JPanel {
    public JPanel headerPanel;
    protected JLabel titleLabel;
    public JPanel mainPanel;

    private final Dimension preferredSize;
    
    private JScrollPane scrollPane;
    
    private int HeaderMinus; // the size of Header of a panel or zero if there is no header
    
    public PanelTitled(String title) {
        this(title, new Dimension(250, 300));
    }
    
    public PanelTitled(Dimension preferredSize) {
        this(null, preferredSize);
    }
    
    public PanelTitled(String title, Dimension preferredSize) {
        this(title, preferredSize, null, true);
    }
    
    public PanelTitled(Dimension preferredSize, Color backgrColor) {
        this(null, preferredSize, backgrColor, true);
    }
    
    public PanelTitled(String title, Dimension preferredSize, Color backgrColor, boolean scrollBar) {
        super();
        this.preferredSize = preferredSize;
        setPreferredSize(preferredSize);
        super.setLayout(new BorderLayout(0, 0));
        Color color = (backgrColor != null ? backgrColor : Constants.NESTED_CONTENT_PANELS_COLOR);
        
        setBackground(color);  // headers of settings panels
        //setBackground(Constants.PINKY_COLOR);
        
        initComponents(title != null ? title : "", scrollBar);
        mainPanel.setOpaque(true);
        mainPanel.setBackground( color); // bodies of settings panels
        //mainPanel.setOpaque(false);
        
    }
    
    private void initComponents(String title, boolean scrollBar) {
        //init inner components
        HeaderMinus = 0;
        if (title!="")
        {
            initHeaderPanel(title);
             HeaderMinus = headerPanel.getPreferredSize().height;          
        }
        initMainPanel();
        //add addEditpanel to "this"
        if (title!="")
            super.add(headerPanel, BorderLayout.PAGE_START);
        //add main panel/scrollPane to "this"
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setUI(new CustomScrollBar(Color.LIGHT_GRAY));
        verticalScrollBar.setBackground(Color.WHITE);
        verticalScrollBar.setPreferredSize(new Dimension(Constants.SCROLLBAR_PREFERRED_WIDTH / 2 + 1, verticalScrollBar.getPreferredSize().height));
        scrollPane.setBorder(new EmptyBorder(new Insets(0,0,2,0)));
        scrollPane.setPreferredSize(new Dimension(preferredSize.width, preferredSize.height - HeaderMinus));
        super.add(scrollPane, BorderLayout.PAGE_END);
    }
    
    protected void initHeaderPanel(String title) {
        //panel
        headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        int headerHeight = 25;
        headerPanel.setPreferredSize(new Dimension(preferredSize.width, headerHeight));
        //FlowLayout layout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        BorderLayout layout = new BorderLayout(0,0);
        headerPanel.setLayout(layout);
        //add add/edit buttons to panel
        
        titleLabel = new JLabel(title);
        
        titleLabel.setPreferredSize(new Dimension(preferredSize.width - 2 * headerHeight, headerHeight));
        titleLabel.setFont(Constants.PANEL_TITLE_FONT_SETTINGS);
        titleLabel.setForeground(Constants.TEXT_COLOR);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.setBorder(new EmptyBorder(new Insets(3, 5, 5, 3)));
    }
    
    protected void initMainPanel() {
        mainPanel = new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                Component[] components = getComponents();
                int weight = 0;
                int height = 0;
                for(Component component : components) {
                    Dimension componentPrefSize = component.getPreferredSize();
                    if(weight < componentPrefSize.width) {
                        weight = componentPrefSize.width;
                    }
                    height += componentPrefSize.height;
                }
                Dimension originalPrefSize = super.getPreferredSize();
                if(weight < originalPrefSize.width) {
                    weight = originalPrefSize.width;
                }
                if(height < originalPrefSize.height) {
                    height = originalPrefSize.height;
                }
                return new Dimension(weight, height);
            }
            
        };
      

        Dimension mainPanelPreferredSize = new Dimension(preferredSize.width - 7/*scroll pane part*/, preferredSize.height - HeaderMinus - 29/*the same*/);
        mainPanel.setPreferredSize(mainPanelPreferredSize);
        mainPanel.setBorder(new EmptyBorder(new Insets(4, 0, 0, 0)));
        FlowLayout mainPanelLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        mainPanel.setLayout(mainPanelLayout);
    }

    @Override
    public Component add(Component comp) {
        return mainPanel.add(comp);
    }
    
    @Override
    public void setLayout(LayoutManager mgr) {
        if(mainPanel != null) {
            mainPanel.setLayout(mgr);
        }
    }
}
