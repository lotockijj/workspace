package MindCastr.components.visionboard;

import MindCastr.components.settings.MyTextField;
import MindCastr.constants.Constants;
import MindCastr.persistent.ImageLoader;
import MindCastr.persistent.ImageUtil;
import MindCastr.utils.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

public class ItemSubmitPanel extends JPanel {

    private static final float ITEM_SUBMIT_PANEL_HEIGHT_FACTOR = .05f;
    private static final Color DRAWABLE_PANEL_BORDER_COLOR = new Color(240, 240, 240);
    public static final Dimension PREFFERED_SIZE = new Dimension(PanelVisionBoard.PREFERRED_SIZE.width -
            Constants.LEFT_PANEL_WIDTH - Constants.GAP_SIZE,
            (int) (PanelVisionBoard.PREFERRED_SIZE.height * ITEM_SUBMIT_PANEL_HEIGHT_FACTOR));
//    private int buttonSize = PREFFERED_SIZE.height;
    private final int buttonSize = 30;
    private final Color headerTextColor = Constants.HEADER_TEXT_COLOR;
    private final Color inputTextColor = Constants.TEXT_COLOR_DARK;
    private final String headerText = "What do you want to Be, Do or Have?";
    private JTextField submitTextField;
    private final PanelVisionBoard panelVisionBoard;
    JPanel drawablePanel;

    public ItemSubmitPanel(PanelVisionBoard panelVisionBoard) {
        //setBackground(Color.WHITE/*TODO: don't hardcode!*/);
        //
        setPreferredSize(new Dimension(PREFFERED_SIZE.width, PREFFERED_SIZE.height + 2 * Constants.GAP_SIZE + 2));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0, 0, Constants.GAP_SIZE, Constants.SCROLLBAR_PREFERRED_WIDTH));

        setLayout(new BorderLayout(0, 0));

        drawablePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, Constants.GAP_SIZE));
        drawablePanel.setOpaque(true);
        drawablePanel.setBackground(Constants.MAIN_PANEL_COLOR);
        drawablePanel.setBorder(BorderFactory.createLineBorder(DRAWABLE_PANEL_BORDER_COLOR));
        


        initTextSubmitField();
        drawablePanel.add(submitTextField);

        this.repaint();
        final JButton imageSubmitButton = getImageSubmitButton();
        drawablePanel.add(imageSubmitButton, BorderLayout.EAST);

        add(drawablePanel, BorderLayout.CENTER);
        this.panelVisionBoard = panelVisionBoard;

        addHierarchyListener(new HierarchyListener() {
            @Override
            public void hierarchyChanged(HierarchyEvent e) {
                if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 || (e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
                    imageSubmitButton.requestFocusInWindow();
                }
            }
        });

    }

    private void initTextSubmitField() {
        submitTextField = new MyTextField();
        submitTextField.getCaret().setBlinkRate(0);


       // submitTextField.setBackground(Constants.MAIN_PANEL_COLOR);
        submitTextField.setForeground(headerTextColor);
        submitTextField.setOpaque(false);
        submitTextField.setText(headerText);

        submitTextField.setBorder(null);
        submitTextField.setPreferredSize(new Dimension(PREFFERED_SIZE.width -  2 * buttonSize + 10, PREFFERED_SIZE.height - 2));
        submitTextField.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);



        submitTextField.setBorder(new EmptyBorder(new Insets(0, 5, 0, 5)));

        submitTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldFocusLost();
            }
        });

        submitTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!submitTextField.getText().isEmpty()) {
                        addSublinimalText(submitTextField.getText());
                        submitTextField.setText("");

                    }
                } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    submitTextField.setText("");
                    textFieldFocusLost();
                }
         //       ItemSubmitPanel.this.repaint();

                panelVisionBoard.refreshMe();
    //  ItemSubmitPanel.this.repaint();


            }
        });
    }

    public void textFieldFocusGained() {
        if (submitTextField.getText().equals(headerText)) {
            submitTextField.setText("");
            submitTextField.setForeground(inputTextColor);
        }
        panelVisionBoard.refreshMe();


    //   this.repaint();

    }

    public void textFieldFocusLost() {
        if (submitTextField.getText().isEmpty()) {
            submitTextField.setText(headerText);
            submitTextField.setForeground(headerTextColor);
        }

   //    this.repaint();

         panelVisionBoard.refreshMe();

    }

    private JButton getImageSubmitButton() {
        final JButton uploadBtn = new JButton(
            Utils.createImageIcon("/ico_camera_normal.png")
        );
        uploadBtn.setRolloverIcon(
            Utils.createImageIcon("/ico_camera_rollover.png")
        );
        uploadBtn.setBorderPainted(false);
        uploadBtn.setContentAreaFilled(false);
        uploadBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        uploadBtn.setPreferredSize(new Dimension(buttonSize, buttonSize));
        uploadBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                final JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new ImageFilter());
                fc.setAcceptAllFileFilterUsed(false);
                fc.setMultiSelectionEnabled(true);

                //Add the preview pane.
                fc.setAccessory(new ImagePreview(fc));

                int retVal = fc.showOpenDialog(ItemSubmitPanel.this);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    File[] files = fc.getSelectedFiles();
                    addSublinimalImmages(files);
                }
            }
        });
        return uploadBtn;
    }

    public void addSublinimalText(String text) {
        VisionItem item = new TextItem(text);
        panelVisionBoard.addItem(item);
    }

    public void addSublinimalImmages(File[] files) {
        for (File file : files) {
            addSublinimalImmage(file);
        }
    }

    public void addSublinimalImmage(File file/*TODO: file?*/) {
        String lightImageUrl = ImageUtil.getLightImageUrl(file.getName());
        Dimension imgSize = ImageUtil.getImgSizeWithoutLoad(file.getAbsolutePath());
        ImageItem item = new ImageItem(lightImageUrl, imgSize);
        ImageLoader.getLoader().addImageToCopy(file.getAbsolutePath(), item);
        panelVisionBoard.addItem(item);
    }

    public class ImageFilter extends FileFilter {

        public final static String jpeg = "jpeg";
        public final static String jpg = "jpg";
        public final static String gif = "gif";
        public final static String tiff = "tiff";
        public final static String tif = "tif";
        public final static String png = "png";

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = Utils.getExtension(f);
            if (extension != null) {
                if (extension.equals(tiff) || extension.equals(tif)
                        || extension.equals(jpeg) || extension.equals(jpg)
                        || extension.equals(gif)
                        || extension.equals(png)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return "Images";
        }
    }

    public class ImagePreview extends JComponent
            implements PropertyChangeListener {

        ImageIcon thumbnail = null;
        File file = null;

        public ImagePreview(JFileChooser fc) {
            setPreferredSize(new Dimension(100, 50));
            fc.addPropertyChangeListener(this);
        }

        public void loadImage() {
            if (file == null) {
                thumbnail = null;
                return;
            }

            //Don't use createImageIcon (which is a wrapper for getResource)
            //because the image we're trying to load is probably not one
            //of this program's own resources.
            ImageIcon tmpIcon = new ImageIcon(file.getPath());
            if (tmpIcon.getIconWidth() > 90) {
                thumbnail = new ImageIcon(tmpIcon.getImage().
                        getScaledInstance(90, -1,
                        Image.SCALE_DEFAULT));
            } else { //no need to miniaturize
                thumbnail = tmpIcon;
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            boolean update = false;
            String prop = e.getPropertyName();

            //If the directory changed, don't show an image.
            if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)) {
                file = null;
                update = true;

                //If a file became selected, find out which one.
            } else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
                file = (File) e.getNewValue();
                update = true;
            }

            //Update the preview accordingly.
            if (update) {
                thumbnail = null;
                if (isShowing()) {
                    loadImage();
                   // repaint();
                    panelVisionBoard.refreshMe();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (thumbnail == null) {
                loadImage();
            }
            if (thumbnail != null) {
                int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
                int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;

                if (y < 0) {
                    y = 0;
                }

                if (x < 5) {
                    x = 5;
                }
                thumbnail.paintIcon(this, g, x, y);
            }

        }
    }
}
