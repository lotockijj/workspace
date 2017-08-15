package com.mindcastr.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.LightGray;

public class App {

	public static void main(String[] args) {
		// Setting L&F used by program
		try {
//			PlasticLookAndFeel.set3DEnabled(true);
//			PlasticLookAndFeel.setPlasticTheme(new LightGray());
//			UIManager.put("jgoodies.useNarrowButtons", Boolean.FALSE);
			UIManager.setLookAndFeel( //
//                    UIManager.getSystemLookAndFeelClassName()); // NO to have the same L&F
//                    "com.jgoodies.looks.plastic.PlasticLookAndFeel");
//                    "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
					"com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					AppFrame frame = new AppFrame();
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setSize(((d.width - d.width / 2) / 3) * 3 - 20, d.height - d.height / 5);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.initMessageList();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
