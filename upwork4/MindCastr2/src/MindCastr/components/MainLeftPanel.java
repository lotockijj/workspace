package MindCastr.components;

import MindCastr.constants.Constants;
import MindCastr.persistent.MouseDragHandler;

import javax.swing.*;
import java.awt.*;

public class MainLeftPanel extends JPanel {

    private static final Color SEPARATOR_COLOR = new Color(220, 220, 220);
    private static final int SEPARATOR_HEIGHT = 3;

    public MainLeftPanel(MouseDragHandler mouseDragHandler) {
        setPreferredSize(new Dimension(Constants.LEFT_PANEL_WIDTH, Constants.LEFT_PANEL_HEIGHT));
        setOpaque(true);
        setBackground(Constants.LEFT_PANEL_BACKGROUND);
        addMouseMotionListener(mouseDragHandler);
        setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setForeground(SEPARATOR_COLOR);
        separator.setBackground(SEPARATOR_COLOR);
        separator.setBounds((int)(Constants.LEFT_PANEL_WIDTH * 0.14f), (int)(Constants.LEFT_PANEL_HEIGHT * 0.9f),
                (int)(Constants.LEFT_PANEL_WIDTH * 0.72f), SEPARATOR_HEIGHT);

        add(separator);
    }
}
