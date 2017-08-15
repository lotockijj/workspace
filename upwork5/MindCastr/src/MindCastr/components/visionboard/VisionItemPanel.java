package MindCastr.components.visionboard;

import MindCastr.components.TransparentButton;
import MindCastr.constants.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VisionItemPanel extends JPanel {
    
    public final VisionItem visionItem;
    private DeleteTransparentButton binButton;
    private VisionBoardColumn parentColumn;
    
    private static final int preferredWidth = PanelVisionBoard.CONTENT_PANEL_PREFERRED_SIZE.width / 3 - 2/*TODO: why -2 ???*/;
    
    public VisionItemPanel(VisionItem visionItem, VisionBoardColumn parentColumn) {
        if(visionItem == null) {
            throw new IllegalArgumentException("content cannot be null.");
        }
        this.visionItem = visionItem;
        this.parentColumn = parentColumn;
        visionItem.setOpaque(true);
        
        //setBorder(new BevelBorder(BevelBorder.LOWERED));
        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        //setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setLayout(new BorderLayout(0, 0));
        int height = visionItem.getPreferredSize().height; 
        Dimension preferredSize = new Dimension(preferredWidth, height);
        //JOptionPane.showMessageDialog(null, height);
        setPreferredSize(preferredSize);
        initComponents();
        setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
       
    }
    
    private void initComponents() {
        JLayeredPane layeredPane = new JLayeredPane();
        Dimension preferredSize = visionItem.getPreferredSize();
        layeredPane.setPreferredSize(preferredSize);
        layeredPane.add(visionItem, 1);
        visionItem.setBounds(0, 0, preferredSize.width, preferredSize.height);
        

        preferredSize = getPreferredSize();
        int buttonSize = 20;
        JPanel binPanel = new JPanel();
        binPanel.setOpaque(false);
        //binPanel.setPreferredSize(new Dimension(preferredSize.width, buttonSize));        
        binPanel.setPreferredSize(new Dimension(preferredSize.width, preferredSize.height));        
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        binPanel.setLayout(flowLayout);
        binPanel.setBounds(0, preferredSize.height - buttonSize, preferredSize.width, preferredSize.height);

        binButton = new DeleteTransparentButton(0f);
        binButton.setBorderPainted(true);
        binButton.setOpaque(true);
        

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Bin Icon(Normal State).png"));
        Image img = imgIcon.getImage();
        Image newImg = img.getScaledInstance(buttonSize-7, buttonSize-7,  Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(newImg);

        binButton.setIcon(imgIcon);
        binButton.setPreferredSize(new Dimension((int) visionItem.getPreferredSize().getWidth(), buttonSize));
        binPanel.add(binButton);

        layeredPane.add(binPanel, 0);

        add(layeredPane);
        
    }

    public boolean isMouseOnBinButton() {
        if(!binButton.isShowing()) {
            return false;
        }
        Point binBtnOnScreen = binButton.getLocationOnScreen();
        Dimension binBtnSize = binButton.getSize();
        Point mouseLocOnScreen = MouseInfo.getPointerInfo().getLocation();
        return (mouseLocOnScreen.x >= binBtnOnScreen.x && mouseLocOnScreen.x <= binBtnOnScreen.x + binBtnSize.width
                && mouseLocOnScreen.y >= binBtnOnScreen.y && mouseLocOnScreen.y <= binBtnOnScreen.y + binBtnSize.height);
    }
    
    public void mouseEntered() {
        if(binButton != null) {
            binButton.setIcon(new ImageIcon(getClass().getResource("/Bin Icon(Hover Effect State).png")));
            binButton.changeTransparency(0.7f);
        }
    }
    
    public void mouseExited() {
        if(binButton != null) {
            binButton.setIcon(new ImageIcon(getClass().getResource("/Bin Icon(Normal State).png")));
            binButton.changeTransparency(0f);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        parentColumn.repaint();
    }
  
      
    class DeleteTransparentButton extends TransparentButton {

        private Color pressedBackgroundColor;
        private Color hoverBackgroundColor;

        private DeleteTransparentButton(float f) {
            super(f);
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
            
        }

        public Color getHoverBackgroundColor() {
            return hoverBackgroundColor;
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public Color getPressedBackgroundColor() {
            return pressedBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }
    }
}
