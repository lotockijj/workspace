package MindCastr.panels;

import MindCastr.autoUpdate.UpdateService;
import MindCastr.components.DropShadowPanel;
import MindCastr.components.MainLeftPanel;
import MindCastr.components.TransparentButton;
import MindCastr.components.settings.PanelSettings;
import MindCastr.components.settings.SmallSettingsImagePanel;
import MindCastr.components.visionboard.PanelVisionBoard;
import MindCastr.constants.Constants;
import MindCastr.persistent.MouseDragHandler;
import MindCastr.persistent.Transport;
import MindCastr.scheduller.VisionItemsSlider;
import MindCastr.utils.JsonReader;
import MindCastr.utils.Utils;
import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    public static final int HEADER_PANEL_HEIGHT;
    public static final int PLAYBACK_PANEL_HEIGHT;
    public static final Dimension MAIN_PANEL_PREFFERED_SIZE;
    private final static float PLAYPAUSEBUTTON_RELATIVE_FACTOR = .80f;
    private final static float SETTINGSBUTTON_RELATIVE_FACTOR = .5f;
    private final static int PLAYPAUSEBUTTON_SIZE;

    //minimize/close button image icons
    private final static ImageIcon playNormalIcon;
    private final static ImageIcon playHoveredIcon;
    private final static ImageIcon pauseNormalIcon;
    private final static ImageIcon pauseHoveredIcon;
    private final static Icon memberBannerIcon;
    private boolean member = false;

    //left panels button image icons
    private final static ImageIcon closeNormalIcon;
    private final static ImageIcon closeHoveredIcon;
    private final static ImageIcon minimizseNormalIcon;
    private final static ImageIcon minimizseHoveredIcon;
    private final static ImageIcon visionBoardNormalIcon;
    private final static ImageIcon visionBoardHoveredIcon;
    private final static ImageIcon myGoalsNormalIcon;
    private final static ImageIcon myGoalsHoveredIcon;
    private final static ImageIcon settingsNormalIcon;
    private final static ImageIcon settingsHoveredIcon;
    private final static ImageIcon powerNormalIcon;
    private final static ImageIcon powerHoveredIcon;

    static {
        HEADER_PANEL_HEIGHT = (int) (Constants.MAIN_HEADER_RELATIVE_FACTOR * Constants.MAIN_WIN_HEIGHT);
        PLAYBACK_PANEL_HEIGHT = (int) (Constants.MAIN_PLAYBACK_RELATIVE_FACTOR * Constants.MAIN_WIN_HEIGHT);
        int mainPanelHeight = Constants.MAIN_WIN_HEIGHT - HEADER_PANEL_HEIGHT - PLAYBACK_PANEL_HEIGHT;
        MAIN_PANEL_PREFFERED_SIZE = new Dimension(Constants.MAIN_WIN_WIDTH, mainPanelHeight);
        PLAYPAUSEBUTTON_SIZE = (int) (PLAYBACK_PANEL_HEIGHT * PLAYPAUSEBUTTON_RELATIVE_FACTOR);

        //init buton icons
        playNormalIcon = Utils.getIcon("/btn_play_normal.png", PLAYPAUSEBUTTON_SIZE);
        playHoveredIcon = Utils.getIcon("/btn_play_hover.png", PLAYPAUSEBUTTON_SIZE);
        pauseNormalIcon = Utils.getIcon("/btn_pause_normal.png", PLAYPAUSEBUTTON_SIZE);
        pauseHoveredIcon = Utils.getIcon("/btn_pause_hover.png", PLAYPAUSEBUTTON_SIZE);
        memberBannerIcon = Utils.getIcon("/memberBannerIcon.png",
                (Constants.MAIN_WIN_WIDTH -Constants.LEFT_PANEL_WIDTH*2),
                PLAYBACK_PANEL_HEIGHT);
        
        //init left panel button icons
        minimizseNormalIcon = Utils.getIcon("/btn_lminimize_normal.png", 20);
        minimizseHoveredIcon = Utils.getIcon("/btn_lminimize_hover.png", 20);
        closeNormalIcon = Utils.getIcon("/btn_lclose_normal.png", 20);
        closeHoveredIcon = Utils.getIcon("/btn_lclose_hover.png", 20);
        visionBoardNormalIcon = (ImageIcon) Utils.getIcon("/btn_vision_board_normal.png", 73, 58);
        visionBoardHoveredIcon = (ImageIcon) Utils.getIcon("/btn_vision_board_hover.png", 73, 58);
        myGoalsNormalIcon = (ImageIcon) Utils.getIcon("/btn_my_goals_normal.png", 80, 57);
        myGoalsHoveredIcon = (ImageIcon) Utils.getIcon("/btn_my_goals_hover.png", 77, 57);
        settingsNormalIcon = Utils.getIcon("/btn_lsettings_normal.png", 58);
        settingsHoveredIcon = Utils.getIcon("/btn_lsettings_hover.png", 58);
        powerNormalIcon = (ImageIcon) Utils.getIcon("/btn_power_normal.png", 34, 34);
        powerHoveredIcon = (ImageIcon) Utils.getIcon("/btn_power_hover.png", 34, 34);
    }

    private JPanel mainPanel;

    private JButton playPauseButton;

    private SmallSettingsImagePanel smallSettingsImagePanel;

    private boolean playing = false;

    private JPanel bodyPanel;
    private final PanelVisionBoard visionBoardPanel;
    private final PanelSettings settingsPanel;

    private JPanel activePanel;

    private final VisionItemsSlider playbackSlider;

    private final MouseDragHandler mouseDragHandler;

    private static MainWindow singleInstance;
    private JButton visionBoardButton;
    private JButton myGoalsButton;
    private JButton lsettingsButton;

    public static MainWindow getInstance() {
        if (singleInstance == null) {
            singleInstance = new MainWindow();
        }
        return singleInstance;
    }

    private MainWindow() {
        setUndecorated(true);
        //AWTUtilities.setWindowOpaque(this, false);

        //this.setOpacity(Constants.MINDCASTR_OPACITY);//
        // Disables full window drag
        // Ref. http://stackoverflow.com/questions/5272358/disable-full-window-drag
// FIXME Add OS conditions
        getRootPane().putClientProperty("apple.awt.draggableWindowBackground",
                Boolean.FALSE);

        setSize(new Dimension(Constants.MAIN_WIN_WIDTH + (Constants.SHADOW_SIZE * 2) - Constants.SCROLLBAR_PREFERRED_WIDTH,
                Constants.MAIN_WIN_HEIGHT + (Constants.SHADOW_SIZE * 2)));

        this.getContentPane().setBackground(Constants.ZERO_COLOR);

        member = isMember();
        mouseDragHandler = new MouseDragHandler(this);

        visionBoardPanel = PanelVisionBoard.createInstance(mouseDragHandler);

        settingsPanel = new PanelSettings(mouseDragHandler);

        visionBoardPanel.setOpaque(true);

        try {
            JsonReader adsReader = JsonReader.getInstance();
            visionBoardPanel.setTutorialUrl(adsReader.getTutorialUrl());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        initComponents();

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(
				new Runnable() {
					@Override
					public void run() {
						new UpdateService(UpdateService.getCurrentVersion()).autoUpdate();
					}
				}, 1, 60, TimeUnit.MINUTES
		);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - Constants.MAIN_WIN_WIDTH) / 2, (dim.height - Constants.MAIN_WIN_HEIGHT) / 2 - 10);
        playbackSlider = new VisionItemsSlider();


        AWTUtilities.setWindowOpaque(this, false);
        JRootPane root = this.getRootPane();
        root.putClientProperty("Window.shadow", Boolean.FALSE);
        this.getContentPane().setBackground(Constants.ZERO_COLOR);

        Executors.newSingleThreadScheduledExecutor()
                .scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                SwingUtilities.invokeLater(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                if (visionBoardPanel.getItemsNumber() == 0) {
                                                    visionBoardPanel.setGuideOn(true);
                                                    //revalidate();
                                                    repaint();
                                                    //   visionBoardPanel.refreshMe();
                                                } else {
                                                    visionBoardPanel.setGuideOn(false);
                                                    //revalidate();
                                                    repaint();
                                                    //  visionBoardPanel.refreshMe();
                                                }
                                            }
                                        }
                                );
                            }
                        }, 0, 1000, TimeUnit.MILLISECONDS
                );
    }

    private boolean isMember() {
        boolean result = false;
        File file = new File(Constants.REG_FILE);
        String mail = "";
        try (FileReader reader = new FileReader(file)) {
            char[] buffer = new char[(int)file.length()];
            reader.read(buffer);
            mail = new String(buffer);
        } catch (IOException e) {

        }
        if (mail.length()>0){
           return new Transport.Http().signIn(mail).paid();
        }
        return result;
    }

    private void initComponents() {
        Container contentPane = getContentPane();

        mainPanel = getMainPanel();

        JPanel playbackPanel = getPlaybackPanel();
        playbackPanel.addMouseMotionListener(mouseDragHandler);

        JPanel leftPanel = getLeftPanel();

        JPanel allPanels = getCombinePanels(mainPanel, playbackPanel, leftPanel);

        JPanel shadowPanel = new DropShadowPanel();
        shadowPanel.add(allPanels, BorderLayout.CENTER);

        contentPane.add(shadowPanel);
    }

    private JPanel getCombinePanels(JPanel mainPanel, JPanel playbackPanel, JPanel leftPanel) {
        JPanel playbackAndMainPanel = new JPanel(new BorderLayout(0, 0));
        playbackAndMainPanel.setOpaque(true);
        playbackAndMainPanel.setBackground(Constants.ZERO_COLOR);
        playbackAndMainPanel.setBorder(BorderFactory.createEmptyBorder(0, Constants.GAP_SIZE, 0, 0));
        playbackAndMainPanel.add(mainPanel, BorderLayout.CENTER);
        playbackAndMainPanel.add(playbackPanel, BorderLayout.SOUTH);

        JPanel allPanels = new JPanel(new BorderLayout(0, 0));
        allPanels.setOpaque(true);
        allPanels.setBackground(Constants.ZERO_COLOR);
        allPanels.setSize(new Dimension(Constants.MAIN_WIN_WIDTH, Constants.MAIN_WIN_HEIGHT));
        allPanels.setLocation(Constants.SHADOW_SIZE, Constants.SHADOW_SIZE);
        allPanels.add(playbackAndMainPanel, BorderLayout.CENTER);
        allPanels.add(leftPanel, BorderLayout.WEST);

        return allPanels;
    }

    private JPanel getMainPanel() {
        //main panel
        bodyPanel = new JPanel(new BorderLayout(0, 0));

        bodyPanel.setPreferredSize(new Dimension(Constants.MAIN_WIN_WIDTH - Constants.LEFT_PANEL_WIDTH - Constants.GAP_SIZE,
                MAIN_PANEL_PREFFERED_SIZE.height));
        activePanel = visionBoardPanel;
        bodyPanel.add(activePanel, BorderLayout.CENTER);
        bodyPanel.setOpaque(true);
        bodyPanel.setBackground(Constants.ZERO_COLOR);
        bodyPanel.repaint();
        return bodyPanel;
    }

    private JPanel getLeftPanel() {
        JPanel leftPanel = new MainLeftPanel(mouseDragHandler);

        JButton closeBtn = getCloseButton();
        leftPanel.add(closeBtn);

        JButton minimizeBtn = getMinimizeButton();
        leftPanel.add(minimizeBtn);

        JButton visionBoardBtn = getVisionBoardButton();
        leftPanel.add(visionBoardBtn);

        JButton myGoalsBtn = getMyGoalsButton();
        leftPanel.add(myGoalsBtn);

        JButton settingBtn = getSettingsButton();
        leftPanel.add(settingBtn);

        JButton powerBtn = getPowerButton();
        leftPanel.add(powerBtn);

        setActiveButton();

        return leftPanel;
    }

    private void setActiveButton() {
        if (activePanel == visionBoardPanel) {
            visionBoardButton.setIcon(visionBoardHoveredIcon);
            myGoalsButton.setIcon(myGoalsNormalIcon);
            lsettingsButton.setIcon(settingsNormalIcon);
        } else if (activePanel == settingsPanel) {
            visionBoardButton.setIcon(visionBoardNormalIcon);
            myGoalsButton.setIcon(myGoalsNormalIcon);
            lsettingsButton.setIcon(settingsHoveredIcon);
        } else {
            visionBoardButton.setIcon(visionBoardNormalIcon);
            myGoalsButton.setIcon(myGoalsHoveredIcon);
            lsettingsButton.setIcon(settingsNormalIcon);
        }
    }

    private JButton getCloseButton() {
        final TransparentButton closeButton = new TransparentButton();
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setIcon(closeNormalIcon);
        closeButton.setRolloverIcon(closeHoveredIcon);
        closeButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.29f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.05f), 20, 20);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        closeButton.setPreferredSize(new Dimension(20, 20));
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playbackSlider.stop();
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        return closeButton;
    }

    private JButton getMinimizeButton() {
        final TransparentButton minimizeButton = new TransparentButton();
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setIcon(minimizseNormalIcon);
        minimizeButton.setRolloverIcon(minimizseHoveredIcon);
        minimizeButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.55f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.05f), 20, 20);
        minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        minimizeButton.setPreferredSize(new Dimension(20, 20));
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButton.setIcon(minimizseNormalIcon);
                setState (Frame.ICONIFIED);
            }
        });
        return minimizeButton;
    }

    private JButton getVisionBoardButton() {
        visionBoardButton = new JButton();
        visionBoardButton.setBorderPainted(false);
        visionBoardButton.setContentAreaFilled(false);
        visionBoardButton.setIcon(visionBoardNormalIcon);
        visionBoardButton.setRolloverIcon(visionBoardHoveredIcon);
        visionBoardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        visionBoardButton.setPreferredSize(new Dimension(73, 58));
        visionBoardButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.18f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.2f), 73, 58);
        visionBoardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if ((activePanel == settingsPanel)) {
                    bodyPanel.remove(activePanel);
                    activePanel = visionBoardPanel;
                    bodyPanel.add(activePanel, BorderLayout.CENTER);
                    smallSettingsImagePanel.show();
                    bodyPanel.revalidate();
                    setActiveButton();
                    repaint();
                }
            }
        });

        return visionBoardButton;
    }

    private JButton getMyGoalsButton() {
        myGoalsButton = new JButton();
        myGoalsButton.setBorderPainted(false);
        myGoalsButton.setContentAreaFilled(false);
        myGoalsButton.setIcon(myGoalsNormalIcon);
        myGoalsButton.setRolloverIcon(myGoalsHoveredIcon);
        myGoalsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        myGoalsButton.setPreferredSize(new Dimension(80, 57));
        myGoalsButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.18f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.45f), 80, 57);
        myGoalsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setActiveButton();
            }
        });

        return myGoalsButton;
    }

    private JButton getSettingsButton() {
        lsettingsButton = new JButton();
        lsettingsButton.setBorderPainted(false);
        lsettingsButton.setContentAreaFilled(false);
        lsettingsButton.setIcon(settingsNormalIcon);
        lsettingsButton.setRolloverIcon(settingsHoveredIcon);
        lsettingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lsettingsButton.setPreferredSize(new Dimension(58, 58));
        lsettingsButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.25f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.7f), 58, 58);
        lsettingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (activePanel == visionBoardPanel) {
                    bodyPanel.remove(activePanel);
                    activePanel = settingsPanel;
                    bodyPanel.add(activePanel, BorderLayout.CENTER);
                    smallSettingsImagePanel.hide();
                    bodyPanel.revalidate();
                    setActiveButton();
                    repaint();
                }
            }
        });

        return lsettingsButton;
    }

    private JButton getPowerButton() {
        final TransparentButton powerButton = new TransparentButton();
        powerButton.setBorderPainted(false);
        powerButton.setContentAreaFilled(false);
        powerButton.setIcon(powerNormalIcon);
        powerButton.setRolloverIcon(powerHoveredIcon);
        powerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        powerButton.setPreferredSize(new Dimension(34, 34));
        powerButton.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.35f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.96f), 34, 34);
        powerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playbackSlider.stop();
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        return powerButton;
    }


    private JPanel getPlaybackPanel() {
        JPanel playbackMainPanel = new JPanel();
        playbackMainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, Constants.SCROLLBAR_PREFERRED_WIDTH));
        playbackMainPanel.setOpaque(false);
        playbackMainPanel.setLayout(new BorderLayout(0, 0));
        JPanel playbackPanel = new JPanel();
        playbackPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, Constants.SCROLLBAR_PREFERRED_WIDTH));
        playbackPanel.setLayout(null);
        playbackPanel.setBackground(Constants.PLAYBACK_PANEL_COLOR);
        playbackPanel.setPreferredSize(new Dimension(Constants.MAIN_WIN_WIDTH - Constants.SCROLLBAR_PREFERRED_WIDTH, PLAYBACK_PANEL_HEIGHT));

        String ads1img = null;
            String ads1url = null;
            try {
                JsonReader adsReader = JsonReader.getInstance();
                ads1img = adsReader.getAds2img();
                ads1url = adsReader.getAds2url();
            } catch (Exception ex) {
                Thread adsScheduler = getAdsScheduler();
                adsScheduler.start();
            }
            smallSettingsImagePanel = new SmallSettingsImagePanel(ads1img, ads1url);
            
        if (member) {
            initPlayPauseButton();
            playbackPanel.add(smallSettingsImagePanel);
            playbackPanel.add(playPauseButton);
            playPauseButton.setBorder(new EmptyBorder(2,0,2,0));
        } else {
            playbackPanel.setLayout(new BorderLayout());
            playbackPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            JButton disabledplayPauseButton = new JButton();
            disabledplayPauseButton.setBorderPainted(false);
            disabledplayPauseButton.setContentAreaFilled(false);
            disabledplayPauseButton.setIcon(memberBannerIcon);
            disabledplayPauseButton.setBorder(new EmptyBorder(0,
                                                Constants.LEFT_PANEL_WIDTH,
                                                0,
                                                0)
                                                );
            disabledplayPauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            disabledplayPauseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        try {
                            desktop.browse(new URI("http://www.mindcastr.com/unlock.html"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            playbackPanel.add(disabledplayPauseButton, BorderLayout.CENTER);
        }


        playbackMainPanel.add(playbackPanel, BorderLayout.EAST);
        return playbackMainPanel;
    }

    private Thread getAdsScheduler() {
        return new Thread(new Runnable() {
            public void run() {
                boolean noExit = true;
                while (noExit) {
                    try {
                        Thread.sleep(1000 * 60);
                        try {
                            JsonReader adsReader = JsonReader.getInstance();
                            if (smallSettingsImagePanel != null) {
                                smallSettingsImagePanel.refresh(adsReader.getAds2img(), adsReader.getAds2url());
                                if (activePanel == visionBoardPanel) {
                                    smallSettingsImagePanel.show();
                                } else {
                                    smallSettingsImagePanel.hide();
                                }
                            }
                            if (settingsPanel != null && settingsPanel.getSettingsImagePanel() != null) {
                                settingsPanel.getSettingsImagePanel().refresh(adsReader.getAds1img(), adsReader.getAds1url());
                            }
                            if (visionBoardPanel != null) {
                                visionBoardPanel.setTutorialUrl(adsReader.getTutorialUrl());
                            }
                            noExit = false;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void initPlayPauseButton() {
        int playpausebutton_X = Constants.MAIN_WIN_WIDTH/2 - PLAYPAUSEBUTTON_SIZE/2 -
                Constants.SCROLLBAR_PREFERRED_WIDTH/2 + Constants.LEFT_PANEL_WIDTH/2;
        int playpausebutton_Y = PLAYBACK_PANEL_HEIGHT/2-PLAYPAUSEBUTTON_SIZE/2 - 5;
        playPauseButton = new JButton();
        playPauseButton.setBorderPainted(false);
        playPauseButton.setContentAreaFilled(false);
        playPauseButton.setIcon(playNormalIcon);
        playPauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playPauseButton.setBounds(playpausebutton_X,
                playpausebutton_Y,
                PLAYPAUSEBUTTON_SIZE,

                PLAYPAUSEBUTTON_SIZE
        );
        playPauseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageIcon icon;
                if (playing) {
                    playing = false;
                    icon = playNormalIcon;
                    playbackSlider.pause();
                } else {
                    playing = true;
                    icon = pauseNormalIcon;
                    playbackSlider.play();
                }
                playPauseButton.setIcon(icon);
                //TODO: call to start play
                //playPauseButton.repaint();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (playing) playPauseButton.setIcon(pauseHoveredIcon);
                else playPauseButton.setIcon(playHoveredIcon);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (playing) playPauseButton.setIcon(pauseNormalIcon);
                else playPauseButton.setIcon(playNormalIcon);
            }
        });
    }

    public void performSettingsButtonClick() {
        bodyPanel.remove(activePanel);
        activePanel = (activePanel == visionBoardPanel ? settingsPanel : visionBoardPanel);
        bodyPanel.add(activePanel, BorderLayout.CENTER);
        if (activePanel == visionBoardPanel) {
            smallSettingsImagePanel.show();
        } else {
            smallSettingsImagePanel.hide();
        }
        bodyPanel.revalidate();
        setActiveButton();
        //bodyPanel.repaint();
        //bodyPanel.getParent().repaint();
        this.repaint();

    }

}
