package MindCastr.panels;

import MindCastr.components.GhostText;
import MindCastr.components.LoginShadowPanel;
import MindCastr.components.LoginWindowBusyIndicatorLayerUI;
import MindCastr.components.Tip;
import MindCastr.constants.Constants;
import MindCastr.persistent.Membership;
import MindCastr.persistent.MouseDragHandler;
import MindCastr.persistent.Transport;
import com.sun.awt.AWTUtilities;
import net.java.balloontip.BalloonTip;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class LoginWindow extends JFrame implements Membership {

    private static final String NAME_EXAMPLE = "name@example.com";
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";

    private static LoginWindow singleInstance;
    private final Dimension gap = new Dimension(0, 10);
    private final int WIN_WIDTH = Constants.LOGIN_WINDOW_WIDTH;
    private final int WIN_HEIGHT = Constants.LOGIN_WINDOW_HEIGHT;
    private final Map<String, JComponent> elements = new HashMap<>();
    private final JPanel panelBottom = new JPanel();
    private final JButton buttonSignUp = new JButton("Sign Up");
    private final JButton buttonSignIn = new JButton("Sign In");
    private final MouseDragHandler mouseDragHandler = new MouseDragHandler(this);
    private final LoginWindowBusyIndicatorLayerUI layerUI = new LoginWindowBusyIndicatorLayerUI(this);

    private LoginWindow() {
        try {
            setIconImage(ImageIO.read(LoginWindow.class
                    .getClass().getResource("/icon.png")));
        } catch (IOException e) {
        }
        //fix for OS
        getRootPane().putClientProperty("apple.awt.draggableWindowBackground",
                Boolean.FALSE);
        setUndecorated(true);

        setSize(new Dimension(WIN_WIDTH + Constants.LOGIN_WINDOW_SHADOW_SIZE * 2,
                WIN_HEIGHT + Constants.LOGIN_WINDOW_SHADOW_SIZE * 2 + Constants.LOGIN_WINDOW_GAP_SIZE));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Constants.MAIN_PANEL_COLOR);
    }
    public static LoginWindow getInstance() {
        if (singleInstance == null) {
            singleInstance = new LoginWindow();
        }
        return singleInstance;
    }

    private void showWindow() {
        Container contentPane = getContentPane();
        addMouseMotionListener(mouseDragHandler);
        JPanel shadowPanel = new LoginShadowPanel();
        JPanel mainPanel = getMainPanel();
        JPanel bottomPanel = getBottomPanel();
        shadowPanel.add(mainPanel);
        shadowPanel.add(bottomPanel);

        JLayer<JPanel> layer = new JLayer<>(shadowPanel, layerUI);

        contentPane.add(layer, BorderLayout.CENTER);

        getRootPane().putClientProperty("apple.awt.draggableWindowBackground",
                Boolean.FALSE);
        AWTUtilities.setWindowOpaque(this, false);
        JRootPane root = this.getRootPane();
        shadowPanel.putClientProperty("Window.shadow", Boolean.FALSE);
        this.getContentPane().setBackground(Constants.MAIN_CONTENT_PANELS_COLOR);
        root.setOpaque(true);

        setVisible(true);
        buttonSignUp.grabFocus();
    }

    private JPanel getMainPanel() {
        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(WIN_WIDTH,
                WIN_HEIGHT - WIN_HEIGHT / 4));
        main.setBorder(new EmptyBorder(10,10,0,0));
        main.setOpaque(true);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBackground(Constants.MAIN_PANEL_COLOR);

        JPanel panelTop = new JPanel();
        panelTop.setOpaque(false);
        panelTop.setBackground(Constants.MAIN_PANEL_COLOR);
        panelTop.setAlignmentX(CENTER_ALIGNMENT);
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.PAGE_AXIS));

        JLabel labelmc2 = new JLabel();
        labelmc2.setIcon(new javax.swing.ImageIcon(getClass().getResource
                ("/top_login.png")));
        labelmc2.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));
        JLabel labelYouMust = new JLabel("You must Sign Up to get Instant " +
                "Access.");
        labelYouMust.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
        labelYouMust.setForeground(Constants.TEXT_COLOR_BLUE);
        labelYouMust.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTop.add(labelmc2);
        labelmc2.setAlignmentX(CENTER_ALIGNMENT);

        panelTop.add(labelYouMust);
        labelYouMust.setAlignmentX(CENTER_ALIGNMENT);
        main.add(panelTop);

        JPanel panelGap = new JPanel();
        panelGap.setOpaque(false);
        panelGap.setLayout(new BoxLayout(panelGap, BoxLayout.Y_AXIS));
        panelGap.setAlignmentX(CENTER_ALIGNMENT);
        panelGap.setBorder(BorderFactory.createEmptyBorder(10, 80, 10, 80));
        main.add(panelGap);

        JPanel panelCenter = new JPanel();
        panelCenter.setOpaque(false);

        panelGap.add(panelCenter);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.PAGE_AXIS));
        panelCenter.add(Box.createRigidArea(gap));

        JTextField textFieldEmail = new JTextField("", 40);
        new GhostText(textFieldEmail, NAME_EXAMPLE);
        textFieldEmail.setSize(new Dimension(470, 30));
        textFieldEmail.setFont(Constants.INNER_COMPONENT_FONT);
        textFieldEmail.setHorizontalAlignment(JTextField.LEFT);
        textFieldEmail.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.lightGray, 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panelCenter.add(textFieldEmail);
        textFieldEmail.addFocusListener(new HighLigt());
        elements.put("email", textFieldEmail);
        panelCenter.add(Box.createRigidArea(gap));

        JPanel panelCenterHorizontal = new JPanel();
        panelCenterHorizontal.setOpaque(false);
        panelCenterHorizontal.setLayout(new BoxLayout(panelCenterHorizontal,
                BoxLayout.LINE_AXIS));
        panelCenter.add(panelCenterHorizontal);
        panelCenter.add(Box.createRigidArea(new Dimension(10, 0)));
        JTextField textFirstName = new JTextField("", 18);
        textFirstName.setFont(Constants.INNER_COMPONENT_FONT);
        new GhostText(textFirstName, FIRST_NAME);
        textFirstName.setHorizontalAlignment(JTextField.LEFT);
        textFirstName.setForeground(Color.lightGray);
        textFirstName.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.lightGray, 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textFirstName.addFocusListener(new HighLigt());
        elements.put("firstname", textFirstName);
        panelCenterHorizontal.add(textFirstName);
        panelCenterHorizontal.add(Box.createRigidArea(new Dimension(15, 0)));

        JTextField textLastName = new JTextField("", 18);
        textLastName.setFont(Constants.INNER_COMPONENT_FONT);
        new GhostText(textLastName, LAST_NAME);

        textLastName.setHorizontalAlignment(JTextField.LEFT);
        textLastName.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.lightGray, 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textLastName.addFocusListener(new HighLigt());
        elements.put("lastname", textLastName);
        panelCenterHorizontal.add(textLastName);

        main.add(Box.createRigidArea(new Dimension(15, 0)));

        JPanel panelGender = new JPanel();

        panelGender.setOpaque(false);
        panelGender.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setFont(Constants.PANEL_LOGIN_FONT_BOLD);
        labelGender.setHorizontalAlignment(JLabel.LEFT);
        labelGender.setBorder(BorderFactory.createEmptyBorder(0, 105, 0, 0));
        panelGender.add(labelGender);

        ButtonGroup group = new ButtonGroup();
        JRadioButton female = new JRadioButton("Female", false);
        female.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        female.setForeground(Color.GRAY);
        female.setOpaque(false);
        female.setBorder(BorderFactory.createEmptyBorder(0, 23, 0, 0));
        female.setFocusPainted(false);
        group.add(female);
        panelGender.add(female);
        elements.put("female", female);

        JRadioButton male = new JRadioButton("Male", true);
        male.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        male.setBorder(BorderFactory.createEmptyBorder(0, 28, 0, 0));
        male.setForeground(Color.GRAY);
        male.setOpaque(false);
        male.setFocusPainted(false);
        group.add(male);
        panelGender.add(male);
        elements.put("male", male);

        labelGender.setAlignmentX(RIGHT_ALIGNMENT);
        main.add(panelGender);

        JPanel panelCheckBox = new JPanel();
        panelCheckBox.setOpaque(false);
        panelCheckBox.setLayout(null);
        panelCheckBox.setBorder(new EmptyBorder(20, 0, 0, 0));
        panelCheckBox.setPreferredSize(new Dimension(WIN_WIDTH, 100));

        JLabel labelWhat = new JLabel("What do you Desire:");
        labelWhat.setFont(Constants.PANEL_LOGIN_FONT_BOLD);
        panelCheckBox.add(labelWhat);

        JLabel labelSelect = new JLabel("<HTML>Select what you want most" +
                "<br>in your life and MC2 will help<br>you achieve it.</HTML>");
        labelSelect.setHorizontalAlignment(SwingConstants.LEFT);
        labelSelect.setFont(Constants.INNER_COMPONENT_SMALL_FONT);
        labelSelect.setForeground(Constants.TEXT_COLOR_DARK);
        elements.put("labelSelect", labelSelect);
        panelCheckBox.add(labelSelect);

        main.add(panelCheckBox);

        JCheckBox checkBoxToLoseWeight = new JCheckBox("To Lose Weight.");
        elements.put("toLoseWeight", checkBoxToLoseWeight);
        checkBoxToLoseWeight.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxToLoseWeight.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxToLoseWeight.setForeground(Color.GRAY);

        JCheckBox checkBoxBetterSex = new JCheckBox("Better Sex.");
        elements.put("betterSex", checkBoxBetterSex);
        checkBoxBetterSex.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxBetterSex.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxBetterSex.setForeground(Color.GRAY);

        JCheckBox checkBoxToCure = new JCheckBox("To Cure My Diabetes.");
        elements.put("toCureMyDiabetes", checkBoxToCure);
        checkBoxToCure.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxToCure.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxToCure.setForeground(Color.GRAY);
        panelCheckBox.add(checkBoxToLoseWeight);
        panelCheckBox.add(checkBoxBetterSex);
        panelCheckBox.add(checkBoxToCure);


        JCheckBox checkBoxFindLove = new JCheckBox("Find Love.");
        elements.put("findLove", checkBoxFindLove);
        checkBoxFindLove.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxFindLove.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxFindLove.setForeground(Color.GRAY);

        JCheckBox checkBoxLawOf = new JCheckBox("Law of Attraction Mastery.");
        elements.put("lawOfAttractionMastery", checkBoxLawOf);
        checkBoxLawOf.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxLawOf.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxLawOf.setForeground(Color.GRAY);

        JCheckBox checkBoxToBecome = new JCheckBox("To Become Rich.");
        elements.put("toBecomeRich", checkBoxToBecome);
        checkBoxToBecome.setFont(Constants.PANEL_LOGIN_FONT_NO_BOLD);
        checkBoxToBecome.setBackground(Constants.MAIN_PANEL_COLOR);
        checkBoxToBecome.setForeground(Color.GRAY);

        panelCheckBox.add(checkBoxFindLove);
        panelCheckBox.add(checkBoxLawOf);
        panelCheckBox.add(checkBoxToBecome);

        //set location
        //1st group
        Insets insets = panelCheckBox.getInsets();
        Dimension size = labelWhat.getPreferredSize();
        labelWhat.setBounds(15 + insets.left, 5 + insets.top,
                size.width, size.height);
        size = labelSelect.getPreferredSize();
        labelSelect.setBounds(20 + insets.left, 30 + insets.top,
                size.width, size.height);

        //2nd group
        size = checkBoxToLoseWeight.getPreferredSize();
        checkBoxToLoseWeight.setBounds(200 + insets.left, insets.top,
                size.width, size.height);
        size = checkBoxBetterSex.getPreferredSize();
        checkBoxBetterSex.setBounds(200 + insets.left, 25 + insets.top,
                size.width, size.height);
        size = checkBoxToCure.getPreferredSize();
        checkBoxToCure.setBounds(200 + insets.left, 50 + insets.top,
                size.width, size.height);

        //3nd group
        size = checkBoxFindLove.getPreferredSize();
        checkBoxFindLove.setBounds(450 + insets.left, insets.top,
                size.width, size.height);
        size = checkBoxLawOf.getPreferredSize();
        checkBoxLawOf.setBounds(450 + insets.left, 25 + insets.top,
                size.width, size.height);
        size = checkBoxToBecome.getPreferredSize();
        checkBoxToBecome.setBounds(450 + insets.left, 50 + insets.top,
                size.width, size.height);

        JPanel panelSignUp = new JPanel();
        panelSignUp.setBorder(new EmptyBorder(20, 10, 10, 10));
        panelSignUp.setOpaque(false);
        buttonSignUp.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
        buttonSignUp.setForeground(Constants.TEXT_COLOR_BLUE);
        buttonSignUp.setOpaque(false);
        buttonSignUp.setBorder(new EmptyBorder(0, 0, 0, 0));
//        buttonSignUp.setFocusPainted(false);
        buttonSignUp.setContentAreaFilled(false);
        buttonSignUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!formIsFilled()){
                    return;
                }
                signUp().start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                underlineOnnOff(buttonSignUp, true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                underlineOnnOff(buttonSignUp, false);
            }
        });
        panelSignUp.add(buttonSignUp);
        main.add(panelSignUp);
        return main;
    }

    private JPanel getBottomPanel() {
        panelBottom.setBackground(Constants.MAIN_PANEL_COLOR);
        panelBottom.setOpaque(true);
        panelBottom.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT / 4));
        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        panelBottom.setAlignmentX(CENTER_ALIGNMENT);
        panelBottom.setBorder(BorderFactory.createEmptyBorder(0, 110, 0, 90));

        JLabel labelMember = new JLabel("If you’re already a Member, enter " +
                "your email to Sign In.");
        labelMember.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
        labelMember.setForeground(Constants.TEXT_COLOR_BLUE);
        labelMember.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 2));
        panelBottom.add(labelMember);
        labelMember.setAlignmentX(CENTER_ALIGNMENT);
        panelBottom.add(Box.createRigidArea(new Dimension(0, 20)));
        final JTextField textFieldMember = new JTextField("", 30);
        new GhostText(textFieldMember, NAME_EXAMPLE);
        elements.put("member", textFieldMember);
        textFieldMember.setMaximumSize(new Dimension(500, 30));
        textFieldMember.setFont(Constants.INNER_COMPONENT_FONT);
        textFieldMember.setAlignmentX(CENTER_ALIGNMENT);
        textFieldMember.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.lightGray, 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panelBottom.add(textFieldMember);
        textFieldMember.setAlignmentX(CENTER_ALIGNMENT);
        textFieldMember.addFocusListener(new HighLigt());

        panelBottom.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBottom.add(Box.createRigidArea(new Dimension(0, 10)));

        buttonSignIn.setFont(Constants.PANEL_TITLE_FONT_NO_BOLD);
        buttonSignIn.setForeground(Constants.TEXT_COLOR_BLUE);
        buttonSignIn.setBorder(new EmptyBorder(0, 0, 0, 0));
        buttonSignIn.setOpaque(false);
        buttonSignIn.setContentAreaFilled(false);
        buttonSignIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField jtxt = (JTextField) elements.get("member");
                String txt = jtxt.getText();
                if (txt.isEmpty() || txt.contains(NAME_EXAMPLE)){
                    new Tip(jtxt, "You must enter your email.").start();
                    return;
                }
                signIn().start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                underlineOnnOff(buttonSignIn, true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                underlineOnnOff(buttonSignIn, false);
            }
        });
        panelBottom.add(buttonSignIn);
        buttonSignIn.setAlignmentX(CENTER_ALIGNMENT);
        return panelBottom;
    }

    @Override
    public boolean check() {

        showWindow();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        return false;
    }

    private void createFile(String mail) {
        Path parent = Paths.get(Constants.REG_FILE).getParent();
        try {
            if (Files.notExists(parent)) {
                Files.createDirectories(parent);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        try (FileWriter fr = new FileWriter(Constants.REG_FILE, false)) {
            fr.write(mail);
            fr.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    private void changeAccessibility(boolean access) {
        if (!access) {
            layerUI.start();
        } else {
            layerUI.stop();
        }
        for (Map.Entry<String, JComponent> element : elements.entrySet()) {
            JComponent tmp = element.getValue();
            tmp.setEnabled(access);
        }
    }

    private void underlineOnnOff(JButton button, boolean onn){
        Font font = button.getFont();
        Map attributes = font.getAttributes();
        if (onn){
            attributes.put(TextAttribute.UNDERLINE, 1);
        }else{
            attributes.put(TextAttribute.UNDERLINE, -1);
        }
        button.setFont(font.deriveFont(attributes));

    }


    private class HighLigt extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            super.focusGained(e);
            if (! e.isTemporary()) {
                JTextField textField = (JTextField)e.getComponent();
                textField.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(Constants.TEXT_COLOR_BLUE, 1, true),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (! e.isTemporary()) {
                JTextField textField = (JTextField)e.getComponent();
                textField.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(Color.lightGray, 1, true),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        }
    }

    private Thread signIn() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                JTextField jtxt = (JTextField) elements.get("member");
                String txt = jtxt.getText();
                changeAccessibility(false);
                Transport.Result result = new Transport.Http().signIn(txt);
                if (result.status()) {
                    createFile(txt);
                    synchronized (LoginWindow.this) {
                        LoginWindow.this.notify();
                    }
                    dispose();
                } else {
                    changeAccessibility(true);
                    new Tip(jtxt, "MindCastr doesn't recognise this email.").start();
                }
            }
        });

        return thread;
    }

    private Thread signUp() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String mail = null;
                Map<String, String> call = new HashMap<>();
                for (Map.Entry<String, JComponent> element : elements.entrySet()) {
                    JComponent tmp = element.getValue();
                    if (tmp instanceof JTextField) {
                        JTextField txt = (JTextField) element.getValue();
                        String key = element.getKey();
                        if (key != "member") {
                            call.put(key, txt.getText());
                            if (key.equals("email")) {
                                mail = txt.getText();
                            }
                        }
                    } else if (tmp instanceof JCheckBox) {
                        JCheckBox chbx = (JCheckBox) element.getValue();
                        call.put(element.getKey(), new Boolean(chbx.isSelected())
                                .toString());
                    } else if (tmp instanceof JRadioButton){
                        JRadioButton rb = (JRadioButton) element.getValue();
                        call.put(element.getKey(), new Boolean(rb.isSelected())
                                .toString());
                    }

                }
                changeAccessibility(false);
                Transport.Result result = new Transport.Http().signUp(call);
                if (result.status()) {
                    createFile(mail);
                    synchronized (LoginWindow.this) {
                        LoginWindow.this.notify();
                    }
                    dispose();
                }else {
                    changeAccessibility(true);
                    new Tip(buttonSignUp, result.details(), BalloonTip.AttachLocation.CENTER).start();
                }
            }
        });

        return thread;
    }

    private boolean formIsFilled() {
        boolean isFilled = true;
        List<Boolean> checkboxes = new ArrayList<>();
        for (Map.Entry<String, JComponent> element : elements.entrySet()) {
            JComponent tmp = element.getValue();
            if (tmp instanceof JTextField) {
                JTextField txt = (JTextField) element.getValue();
                if (!element.getKey().equals("member")) {
                    if (txt.getText().isEmpty()
                            || txt.getText().equals(NAME_EXAMPLE)
                            || txt.getText().equals(FIRST_NAME)
                            || txt.getText().equals(LAST_NAME)) {
                        isFilled = false;
                        new Tip(txt, "You can't leave this empty").start();
                    }
                }
            } else if (tmp instanceof JCheckBox) {
                JCheckBox chbx = (JCheckBox) element.getValue();
                checkboxes.add(chbx.isSelected());
            }
        }

        boolean boxIsSelected = false;

        for (boolean checkbox : checkboxes) {
            if (checkbox) {
                boxIsSelected = true;
                break;
            }
        }
        if (!boxIsSelected) {
            isFilled = false;
            JLabel labelSelect = (JLabel) elements.get("labelSelect");
            new Tip(labelSelect, "You must Choose Desire", BalloonTip.AttachLocation.CENTER).start();
        }

        return isFilled;
    }
}

