package MindCastr.components;

import MindCastr.constants.Constants;
import MindCastr.utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoginShadowPanel extends JPanel {

    public LoginShadowPanel() {
        setPreferredSize(new Dimension(Constants.LOGIN_WINDOW_WIDTH, Constants.LOGIN_WINDOW_HEIGHT + Constants.LOGIN_WINDOW_GAP_SIZE));
        setBackground(Constants.ZERO_COLOR);
        setBorder(new EmptyBorder(Constants.LOGIN_WINDOW_GAP_SIZE, 0, 0, 0));
        setLayout(new FlowLayout(FlowLayout.LEADING, Constants.LOGIN_WINDOW_SHADOW_SIZE, Constants.LOGIN_WINDOW_GAP_SIZE));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Constants.MAIN_PANEL_COLOR);
        g.fillRect(Constants.LOGIN_WINDOW_SHADOW_SIZE,
                Constants.LOGIN_WINDOW_SHADOW_SIZE + 5,
                Constants.LOGIN_WINDOW_WIDTH,
                Constants.LOGIN_WINDOW_HEIGHT + Constants.LOGIN_WINDOW_GAP_SIZE);

        BufferedImage backgroundImage = Utils.getBufferedImage("/panel_login_shadow_background.png");
        g.drawImage(backgroundImage, 0, 0,
                backgroundImage.getWidth(),
                backgroundImage.getHeight(),
                null);
    }
}
