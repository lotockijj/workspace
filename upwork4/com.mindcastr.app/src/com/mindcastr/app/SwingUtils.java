package com.mindcastr.app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class SwingUtils {

	private SwingUtils() {
	}

	public static JButton makeFlat(JButton button) {
		class FlatButtonUI extends BasicButtonUI {
			@Override
			public void paint(Graphics g, JComponent c) {
				final AbstractButton cc = (AbstractButton) c;
				ButtonModel model = cc.getModel();
				Icon icon = null;
				if (model.isRollover()) {
					icon = cc.getRolloverIcon();
				}
				if (icon == null) {
					icon = cc.getIcon();
				}
				icon.paintIcon(cc, g,
						(cc.getWidth() - icon.getIconWidth()) / 2,
						(cc.getHeight() - icon.getIconHeight()) / 2);
			}
		}
		button.setUI(new FlatButtonUI());
		button.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		button.setRolloverEnabled(true);
		return button;
	}

	public static Icon getIcon(String imagePath) {
		return new ImageIcon(SwingUtils.class.getResource("/r/" + imagePath));
	}
}
