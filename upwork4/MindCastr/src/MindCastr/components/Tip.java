package MindCastr.components;

import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.TimingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Igor on 10.12.2016.
 */
public class Tip extends BalloonTip {
    private static final Color BACKGROUND_COLOR = new Color(255, 51, 51);
    private static final int ARC = 1;
    private static final int H_OFFSET = 15;
    private static final int V_OFFSET = 5;
    private static final int PADDING = 3;
    private static final int DELAY = 2500;

    public Tip(JComponent component, String tipText) {
        this(component, tipText, AttachLocation.SOUTHWEST);
    }

    public Tip(JComponent component, String tipText, AttachLocation attachLocation) {
        super(component, new JLabel("<html><font color='white'>" + tipText + "</font></html>"),
                new RoundedBalloonStyle(ARC, ARC, BACKGROUND_COLOR, BACKGROUND_COLOR),
                Orientation.LEFT_BELOW, attachLocation, H_OFFSET, V_OFFSET, false);
        setPadding(PADDING);
    }

    public void start() {
        TimingUtils.showTimedBalloon(this, DELAY);
    }
}