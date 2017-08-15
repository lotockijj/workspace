package MindCastr.dropdown.colorchooser;

import MindCastr.components.settings.SettingsConfig;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DropDownColorChooser extends JPanel {
    
    protected JComponent drop_down_comp;
    protected JWindow popup;
    boolean buttonPressed = false;
    
    public DropDownColorChooser(JComponent previewComponent) {
        super();
        setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        setPreferredSize(new Dimension(23, 23));
        setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        addListeners();
        initDropDownContent(previewComponent);
    }
    
    private void addListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buildPopup();
                if (!popup.isVisible() && !buttonPressed) {
                    Point pt = getLocationOnScreen();
                    pt.translate(0, getHeight());
                    popup.setLocation(pt);
                    popup.toFront();
                    popup.setVisible(true);
                    popup.requestFocusInWindow();
                    buttonPressed = true;
                } else {
                    buttonPressed = false;
                }
            }
        });
    }
    
    private void initDropDownContent(final JComponent previewComponent) {
        drop_down_comp = new JPanel();
        final JColorChooser cc = new JColorChooser();
        cc.setPreviewPanel(previewComponent);
        cc.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color color = cc.getColor();
                DropDownColorChooser.this.setBackground(color);
                SettingsConfig.getInstance().getFontSettings().color = color;
            }
        });
        JButton closeBtn = new JButton("Close");
        Dimension btnPreferredSize = closeBtn.getPreferredSize();
        Dimension ccPreferredSize = cc.getPreferredSize();
        drop_down_comp.setPreferredSize(new Dimension(ccPreferredSize.width, ccPreferredSize.height + btnPreferredSize.height + 15));
        drop_down_comp.add(cc, BorderLayout.CENTER);
        drop_down_comp.add(closeBtn, BorderLayout.PAGE_END);
        
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popup.setVisible(false);
            }
        });
        
    }
    
    private void buildPopup() {
        if (popup != null) {
            return;
        }
        popup = new JWindow(getFrame(null));
        popup.getContentPane().add(drop_down_comp);
        popup.pack();
        
        popup.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent evt) {
                Point thisCompLocOnScreen = getLocationOnScreen();
                Dimension thisComponentSize = getSize();
                Point mouseLocOnScreen = MouseInfo.getPointerInfo().getLocation();
                if (mouseLocOnScreen.x >= thisCompLocOnScreen.x && mouseLocOnScreen.x <= thisCompLocOnScreen.x + thisComponentSize.width
                        && mouseLocOnScreen.y >= thisCompLocOnScreen.y && mouseLocOnScreen.y <= thisCompLocOnScreen.y + thisComponentSize.height) {
                    buttonPressed = true;
                } else {
                    buttonPressed = false;
                }
                popup.setVisible(false);
            }
        });
    }
    
    protected Frame getFrame(Component comp) {
        if (comp == null) {
            comp = this;
        }
        if (comp.getParent() instanceof Frame) {
            return (Frame) comp.getParent();
        }
        return getFrame(comp.getParent());
    }
}
