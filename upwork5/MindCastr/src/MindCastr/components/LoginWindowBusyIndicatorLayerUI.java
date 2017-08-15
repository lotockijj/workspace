package MindCastr.components;

import MindCastr.constants.Constants;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

/**
 * Created by Igor on 29.11.2016.
 */
public class LoginWindowBusyIndicatorLayerUI extends LayerUI<JPanel> {

    private static int IMAGE_WIDTH;
    private static int IMAGE_HEIGHT;
    private static final String IMAGE_PATH = "/busy_indicator_login_window.gif";
    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0, 0.1f);

    private final Image busyIndicatorImage;
    private final JFrame loginWindowFrame;

    private boolean isRunning;

    public LoginWindowBusyIndicatorLayerUI(JFrame loginWindowFrame) {
        busyIndicatorImage = new ImageIcon(this.getClass().getResource(IMAGE_PATH)).getImage();
        this.loginWindowFrame = loginWindowFrame;

        IMAGE_WIDTH = busyIndicatorImage.getWidth(null);
        IMAGE_HEIGHT = busyIndicatorImage.getHeight(null);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);

        if (!isRunning) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(BACKGROUND_COLOR);
        g2.fillRect(Constants.LOGIN_WINDOW_SHADOW_SIZE,
                Constants.LOGIN_WINDOW_SHADOW_SIZE + 5,
                Constants.LOGIN_WINDOW_WIDTH,
                Constants.LOGIN_WINDOW_HEIGHT + Constants.LOGIN_WINDOW_GAP_SIZE);

        g2.drawImage(busyIndicatorImage,
                loginWindowFrame.getWidth() / 2 - IMAGE_WIDTH / 2,
                loginWindowFrame.getHeight() / 2 - IMAGE_HEIGHT / 2,
                IMAGE_WIDTH, IMAGE_HEIGHT, loginWindowFrame);

        g2.dispose();
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }
}
