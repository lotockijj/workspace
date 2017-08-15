package MindCastr.components;

import MindCastr.constants.Constants;
import MindCastr.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class DropShadowPanel extends JPanel {

    public DropShadowPanel() {
        setPreferredSize(new Dimension(Constants.MAIN_WIN_WIDTH, Constants.MAIN_WIN_HEIGHT));
        setBackground(Constants.ZERO_COLOR);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage backgroundImage = Utils.getBufferedImage("/panel_drop_shadow_background.png");
        g.drawImage(backgroundImage, -15, 0, 950, 950, null);
    }
}
