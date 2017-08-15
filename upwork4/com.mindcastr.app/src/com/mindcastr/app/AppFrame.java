package com.mindcastr.app;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JLabel;

import com.sun.awt.AWTUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Font;
import java.util.UUID;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class AppFrame extends JFrame {

	private final DefaultListModel model = new DefaultListModel();
	
	
	private JTextField textField;
	private JPanel cardPane;
	
	private boolean visionBoardActive = true;
	
	private JList messagesList;

	public AppFrame() {
		initGUI();
		MouseAdapter listener = new MouseAdapter() {

			private int mx, my;

			@Override
			public void mousePressed(MouseEvent e) {
				Point p = getLocation();
				mx = p.x - e.getXOnScreen();
				my = p.y - e.getYOnScreen();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(mx + e.getXOnScreen(), my + e.getYOnScreen());
			}
		};
		initDragListener(listener, getContentPane());
		CardLayout cardLayout = (CardLayout) cardPane
				.getLayout();
		cardLayout.show(cardPane, "visionBoardPane");
		initMessageList();
	}

	void initDragListener(MouseAdapter listener, Container container) {
		for (int i = 0; i < container.getComponentCount(); i++) {
			Component c = container.getComponent(i);
			if (c instanceof Container) {
				initDragListener(listener, (Container) c);
			}
			if (c instanceof JPanel || c instanceof AbstractButton
					|| c instanceof JLabel || c instanceof JList) {
				c.addMouseListener(listener);
				c.addMouseMotionListener(listener);
			}
		}
	}
	
	void initMessageList() {
		for (int i = 0; i < 4; i++) {
			model.addElement("<html>" + UUID.randomUUID() + " " + UUID.randomUUID() + " " + UUID.randomUUID());
		}
		messagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		messagesList.setVisibleRowCount(0);
		messagesList.setFixedCellWidth(messagesList.getWidth() / 3);
		messagesList.setCellRenderer(new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				
				Component c =
				 super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				c.setPreferredSize(new Dimension(250, 100));
				return c;
			}
		});
		messagesList.setModel(model);
	}

	private void initGUI() {
		setUndecorated(true);
		AWTUtilities.setWindowOpaque(this, false);
		AWTUtilities.setWindowOpacity(this, 0.90f);

		// Disables full window drag on Mac OS
		// Ref. http://stackoverflow.com/questions/5272358/disable-full-window-drag
// TODO Add OS conditions		
		getRootPane().putClientProperty("apple.awt.draggableWindowBackground",
				Boolean.FALSE);

		final JPanel contentPane = new JPanel();
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		{
			JPanel titlePane = new JPanel();
			titlePane.setOpaque(false);
			GridBagConstraints gbc_titlePane = new GridBagConstraints();
			gbc_titlePane.insets = new Insets(0, 0, 5, 0);
			gbc_titlePane.anchor = GridBagConstraints.NORTH;
			gbc_titlePane.fill = GridBagConstraints.HORIZONTAL;
			gbc_titlePane.gridx = 0;
			gbc_titlePane.gridy = 0;
			contentPane.add(titlePane, gbc_titlePane);
			GridBagLayout gbl_titlePane = new GridBagLayout();
			gbl_titlePane.columnWidths = new int[] { 0, 0, 0 };
			gbl_titlePane.rowHeights = new int[] { 0, 0 };
			gbl_titlePane.columnWeights = new double[] { 1.0, 0.0,
					Double.MIN_VALUE };
			gbl_titlePane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			titlePane.setLayout(gbl_titlePane);
			{
				JButton btnX = new JButton();
				btnX.setBackground(new Color(0, 0, 0, 0));
				btnX.setIcon(SwingUtils.getIcon("exit-normal.png"));
				btnX.setRolloverIcon(SwingUtils.getIcon("exit-hover.png"));
				btnX.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				{
					JButton btnNewButton = new JButton();
					btnNewButton.setBackground(new Color(0, 0, 0, 0));
					btnNewButton.setIcon(SwingUtils
							.getIcon("minimize-normal.png"));
					btnNewButton.setRolloverIcon(SwingUtils
							.getIcon("minimize-hover.png"));
					SwingUtils.makeFlat(btnNewButton);
					GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
					gbc_btnNewButton.anchor = GridBagConstraints.SOUTHEAST;
					gbc_btnNewButton.insets = new Insets(0, 0, 0, 3);
					gbc_btnNewButton.gridx = 0;
					gbc_btnNewButton.gridy = 0;
					titlePane.add(btnNewButton, gbc_btnNewButton);
				}
				SwingUtils.makeFlat(btnX);
				GridBagConstraints gbc_btnX = new GridBagConstraints();
				gbc_btnX.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnX.anchor = GridBagConstraints.SOUTH;
				gbc_btnX.gridx = 1;
				gbc_btnX.gridy = 0;
				titlePane.add(btnX, gbc_btnX);
			}
		}
		{
			cardPane = new JPanel();
			cardPane.setOpaque(false);
			GridBagConstraints gbc_cardPane = new GridBagConstraints();
			gbc_cardPane.insets = new Insets(0, 0, 3, 0);
			gbc_cardPane.fill = GridBagConstraints.BOTH;
			gbc_cardPane.gridx = 0;
			gbc_cardPane.gridy = 1;
			contentPane.add(cardPane, gbc_cardPane);
			cardPane.setLayout(new CardLayout(0, 0));
			{
				JPanel visionBoardPane = new JPanel();
				visionBoardPane.setOpaque(false);
				cardPane.add(visionBoardPane, "visionBoardPane");
				GridBagLayout gbl_visionBoardPane = new GridBagLayout();
				gbl_visionBoardPane.columnWidths = new int[] { 0, 32, 0 };
				gbl_visionBoardPane.rowHeights = new int[] { 32, 0, 0 };
				gbl_visionBoardPane.columnWeights = new double[] { 1.0, 0.0,
						Double.MIN_VALUE };
				gbl_visionBoardPane.rowWeights = new double[] { 0.0, 1.0,
						Double.MIN_VALUE };
				visionBoardPane.setLayout(gbl_visionBoardPane);
				{
					textField = new JTextField();
					textField.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							model.addElement(textField.getText());
							textField.setText("");
						}
					});
					GridBagConstraints gbc_textField = new GridBagConstraints();
					gbc_textField.fill = GridBagConstraints.BOTH;
					gbc_textField.insets = new Insets(0, 0, 3, 3);
					gbc_textField.gridx = 0;
					gbc_textField.gridy = 0;
					visionBoardPane.add(textField, gbc_textField);
					textField.setColumns(10);
				}
				{
					JButton btnPh = new JButton();
					btnPh.setFocusable(false);
					btnPh.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JFileChooser fc = new JFileChooser();
							fc.showOpenDialog(AppFrame.this);
						}
					});
					GridBagConstraints gbc_btnPh = new GridBagConstraints();
					gbc_btnPh.insets = new Insets(0, 0, 3, 0);
					gbc_btnPh.fill = GridBagConstraints.BOTH;
					gbc_btnPh.gridx = 1;
					gbc_btnPh.gridy = 0;
					visionBoardPane.add(btnPh, gbc_btnPh);
//					btnPh.setBackground(new Color(0, 0, 0, 0));
					btnPh.setIcon(SwingUtils.getIcon("camera-normal.png"));
					btnPh.setRolloverIcon(SwingUtils
							.getIcon("camera-hover.png"));

//					btnPh.setOpaque(true);
//					btnPh.setBorder(BorderFactory.createCompoundBorder(
//							BorderFactory.createLineBorder(Color.BLACK),
//							BorderFactory.createEmptyBorder(3, 3, 3, 3)));
//					SwingUtils.makeFlat(btnPh);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
//					scrollPane.getViewport().setBorder(null);
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.gridwidth = 2;
					gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridx = 0;
					gbc_scrollPane.gridy = 1;
					visionBoardPane.add(scrollPane, gbc_scrollPane);
					{
						messagesList = new JList();
						scrollPane.setViewportView(messagesList);
					}
				}
			}
			{
				SettingsPane settingPane = new SettingsPane();
				cardPane.add(settingPane, "settingPane");
			}
		}
		{
			JPanel bottomBarPane = new JPanel();
			
//			bottomBarPane.setBackground(Color.BLACK);
//			bottomBarPane.setForeground(Color.WHITE);
			
			bottomBarPane.setOpaque(false);
			GridBagConstraints gbc_bottomBarPane = new GridBagConstraints();
			gbc_bottomBarPane.fill = GridBagConstraints.BOTH;
			gbc_bottomBarPane.gridx = 0;
			gbc_bottomBarPane.gridy = 2;
			contentPane.add(bottomBarPane, gbc_bottomBarPane);
			GridBagLayout gbl_bottomBarPane = new GridBagLayout();
			gbl_bottomBarPane.columnWidths = new int[] { 0, 0, 0, 0 };
			gbl_bottomBarPane.rowHeights = new int[] { 0, 0 };
			gbl_bottomBarPane.columnWeights = new double[] { 0.0, 1.0, 0.0,
					Double.MIN_VALUE };
			gbl_bottomBarPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			bottomBarPane.setLayout(gbl_bottomBarPane);
			{
				JButton btnM = new JButton();
				
//				btnM.setOpaque(false);
//				btnM.setBackground(Color.BLACK);
				btnM.setBackground(new Color(0, 128, 0));
//				SwingUtils.makeFlat(btnM);
				
				btnM.setIcon(SwingUtils.getIcon("play.png"));
				GridBagConstraints gbc_btnM = new GridBagConstraints();
				gbc_btnM.fill = GridBagConstraints.BOTH;
				gbc_btnM.insets = new Insets(0, 0, 0, 3);
				gbc_btnM.gridx = 0;
				gbc_btnM.gridy = 0;
				bottomBarPane.add(btnM, gbc_btnM);
			}
			{
				JLabel lblNewLabel = new JLabel("MindCastr.com");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(Color.GRAY);
				lblNewLabel.setOpaque(true);
				lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
				lblNewLabel.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 3);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 0;
				bottomBarPane.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				JButton btnS = new JButton();
				btnS.setFocusable(false);
				btnS.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						CardLayout cardLayout = (CardLayout) cardPane
								.getLayout();
//						cardLayout.show(cardPane, "visionBoardPane");
//						cardPane.add(settingPane, "settingPane");
						
						if (visionBoardActive) {
							cardLayout.show(cardPane, "settingPane");
						} else {
							cardLayout.show(cardPane, "visionBoardPane");
						}
						visionBoardActive = !visionBoardActive;
					}
				});
				btnS.setBackground(Color.BLACK);
				btnS.setIcon(SwingUtils.getIcon("settings.png"));
//				SwingUtils.makeFlat(btnS);
				GridBagConstraints gbc_btnS = new GridBagConstraints();
				gbc_btnS.fill = GridBagConstraints.BOTH;
				gbc_btnS.gridx = 2;
				gbc_btnS.gridy = 0;
				bottomBarPane.add(btnS, gbc_btnS);
			}
		}
	}
}
