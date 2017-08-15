package com.mindcastr.app;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class SettingsPane extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox cmbxFontSizes;
	private JComboBox cmbxFontNames;
	private JButton btnFontColor;
	private JSlider transparencySlider;

	public SettingsPane() {
		initGUI();
		initListeners();
	}
	
	private void initListeners() {
		for (String o : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
			cmbxFontNames.addItem(o);
		}
		for (int i = 3; i <= 72; i *= 2) {
			cmbxFontSizes.addItem(i);
		}
		cmbxFontSizes.setSelectedIndex(4);
	}

	private void initGUI() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 3));
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
//				panel_1.setBackground(Color.GRAY);
//				panel_1.setBorder(BorderFactory.createCompoundBorder(
//						BorderFactory.createLineBorder(Color.BLACK),
//						BorderFactory.createEmptyBorder(4, 4, 4, 4)));
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
			}
			{
				JButton btnSetToDefault = new JButton("Set To Default");

				btnSetToDefault.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				btnSetToDefault.setBackground(Color.GRAY);
				btnSetToDefault.setForeground(Color.WHITE);
				
				GridBagConstraints gbc_btnSetToDefault = new GridBagConstraints();
				gbc_btnSetToDefault.anchor = GridBagConstraints.EAST;
				gbc_btnSetToDefault.insets = new Insets(0, 0, 0, 5);
				gbc_btnSetToDefault.gridx = 1;
				gbc_btnSetToDefault.gridy = 0;
				panel.add(btnSetToDefault, gbc_btnSetToDefault);
			}
			{
				JButton btnAllDone = new JButton("All Done!");
				btnAllDone.setFont(new Font("Lucida Grande", Font.BOLD, 15));
//				btnAllDone.setIcon(SwingUtils.getIcon("all-done-normal.png"));
//				btnAllDone.setBorder(BorderFactory.createEmptyBorder(1, 2, 1, 2));
				btnAllDone.setBackground(new Color(255, 0, 0, 198));
				btnAllDone.setForeground(Color.WHITE);

				GridBagConstraints gbc_btnAllDone = new GridBagConstraints();
				gbc_btnAllDone.gridx = 2;
				gbc_btnAllDone.gridy = 0;
				panel.add(btnAllDone, gbc_btnAllDone);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(
//					BorderFactory.createCompoundBorder(
//					BorderFactory.createLineBorder(Color.BLACK),
					BorderFactory.createEmptyBorder(3, 3, 3, 3));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.insets = new Insets(0, 0, 0, 5);
				gbc_panel_2.gridx = 0;
				gbc_panel_2.gridy = 0;
				panel.add(panel_2, gbc_panel_2);
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[] { 0, 0 };
				gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
				gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 1.0,
						Double.MIN_VALUE };
				panel_2.setLayout(gbl_panel_2);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
					panel_1.setBackground(Color.WHITE);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.insets = new Insets(0, 0, 5, 0);
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
					panel_2.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
					gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
					gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
							Double.MIN_VALUE };
					gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0,
							Double.MIN_VALUE };
					panel_1.setLayout(gbl_panel_1);
					{
						JLabel lblTimeSettings = new JLabel("Time Settings");
						makeBigLabel(lblTimeSettings);
						GridBagConstraints gbc_lblTimeSettings = new GridBagConstraints();
						gbc_lblTimeSettings.anchor = GridBagConstraints.WEST;
						gbc_lblTimeSettings.gridwidth = 3;
						gbc_lblTimeSettings.insets = new Insets(0, 0, 5, 5);
						gbc_lblTimeSettings.gridx = 0;
						gbc_lblTimeSettings.gridy = 0;
						panel_1.add(lblTimeSettings, gbc_lblTimeSettings);
					}
					{
						JLabel lblDisplayEvery = new JLabel("Display Every");
						GridBagConstraints gbc_lblDisplayEvery = new GridBagConstraints();
						gbc_lblDisplayEvery.insets = new Insets(0, 0, 5, 5);
						gbc_lblDisplayEvery.anchor = GridBagConstraints.WEST;
						gbc_lblDisplayEvery.gridx = 0;
						gbc_lblDisplayEvery.gridy = 1;
						panel_1.add(lblDisplayEvery, gbc_lblDisplayEvery);
					}
					{
						textField = new JTextField();
						textField.setText("4");
						GridBagConstraints gbc_textField = new GridBagConstraints();
						gbc_textField.insets = new Insets(0, 0, 5, 5);
						gbc_textField.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField.gridx = 1;
						gbc_textField.gridy = 1;
						panel_1.add(textField, gbc_textField);
						textField.setColumns(10);
					}
					{
						JLabel lblSeconds = new JLabel("Seconds");
						GridBagConstraints gbc_lblSeconds = new GridBagConstraints();
						gbc_lblSeconds.anchor = GridBagConstraints.WEST;
						gbc_lblSeconds.insets = new Insets(0, 0, 5, 0);
						gbc_lblSeconds.gridx = 2;
						gbc_lblSeconds.gridy = 1;
						panel_1.add(lblSeconds, gbc_lblSeconds);
					}
					{
						JLabel lblDisplayFor = new JLabel("Display For");
						GridBagConstraints gbc_lblDisplayFor = new GridBagConstraints();
						gbc_lblDisplayFor.anchor = GridBagConstraints.EAST;
						gbc_lblDisplayFor.insets = new Insets(0, 0, 0, 5);
						gbc_lblDisplayFor.gridx = 0;
						gbc_lblDisplayFor.gridy = 2;
						panel_1.add(lblDisplayFor, gbc_lblDisplayFor);
					}
					{
						textField_1 = new JTextField();
						textField_1.setText("500");
						GridBagConstraints gbc_textField_1 = new GridBagConstraints();
						gbc_textField_1.insets = new Insets(0, 0, 0, 5);
						gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_1.gridx = 1;
						gbc_textField_1.gridy = 2;
						panel_1.add(textField_1, gbc_textField_1);
						textField_1.setColumns(10);
					}
					{
						JLabel lblMiliseconds = new JLabel("Miliseconds");
						GridBagConstraints gbc_lblMiliseconds = new GridBagConstraints();
						gbc_lblMiliseconds.anchor = GridBagConstraints.WEST;
						gbc_lblMiliseconds.gridx = 2;
						gbc_lblMiliseconds.gridy = 2;
						panel_1.add(lblMiliseconds, gbc_lblMiliseconds);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
					panel_1.setBackground(Color.WHITE);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.insets = new Insets(0, 0, 5, 0);
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 1;
					panel_2.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[] { 0, 0 };
					gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
					gbl_panel_1.columnWeights = new double[] { 0.0,
							Double.MIN_VALUE };
					gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
							Double.MIN_VALUE };
					panel_1.setLayout(gbl_panel_1);
					{
						JLabel lblMessageLocation = new JLabel("Message Location");
						makeBigLabel(lblMessageLocation);
						GridBagConstraints gbc_lblMessageLocation = new GridBagConstraints();
						gbc_lblMessageLocation.anchor = GridBagConstraints.WEST;
						gbc_lblMessageLocation.insets = new Insets(0, 0, 5, 0);
						gbc_lblMessageLocation.gridx = 0;
						gbc_lblMessageLocation.gridy = 0;
						panel_1.add(lblMessageLocation, gbc_lblMessageLocation);
					}
					{
						JRadioButton rdbtnDisplayRandomlyOn = new JRadioButton(
								"Display Randomly On Screen");
						rdbtnDisplayRandomlyOn.setOpaque(false);
						GridBagConstraints gbc_rdbtnDisplayRandomlyOn = new GridBagConstraints();
						gbc_rdbtnDisplayRandomlyOn.anchor = GridBagConstraints.WEST;
						gbc_rdbtnDisplayRandomlyOn.insets = new Insets(0, 0, 5, 0);
						gbc_rdbtnDisplayRandomlyOn.gridx = 0;
						gbc_rdbtnDisplayRandomlyOn.gridy = 1;
						panel_1.add(rdbtnDisplayRandomlyOn,
								gbc_rdbtnDisplayRandomlyOn);
					}
					{
						JRadioButton rdbtnDisplayCenterOf = new JRadioButton(
								"Display Center Of Screen");
						rdbtnDisplayCenterOf.setOpaque(false);
						GridBagConstraints gbc_rdbtnDisplayCenterOf = new GridBagConstraints();
						gbc_rdbtnDisplayCenterOf.anchor = GridBagConstraints.WEST;
						gbc_rdbtnDisplayCenterOf.insets = new Insets(0, 0, 5, 0);
						gbc_rdbtnDisplayCenterOf.gridx = 0;
						gbc_rdbtnDisplayCenterOf.gridy = 2;
						panel_1.add(rdbtnDisplayCenterOf, gbc_rdbtnDisplayCenterOf);
					}
					{
						JRadioButton rdbtnDisplayBottomRight = new JRadioButton(
								"Display Bottom Right Of Screen");
						rdbtnDisplayBottomRight.setOpaque(false);
						GridBagConstraints gbc_rdbtnDisplayBottomRight = new GridBagConstraints();
						gbc_rdbtnDisplayBottomRight.anchor = GridBagConstraints.WEST;
						gbc_rdbtnDisplayBottomRight.gridx = 0;
						gbc_rdbtnDisplayBottomRight.gridy = 3;
						panel_1.add(rdbtnDisplayBottomRight,
								gbc_rdbtnDisplayBottomRight);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
					panel_1.setBackground(Color.WHITE);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 2;
					panel_2.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
					gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
					gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0,
							Double.MIN_VALUE };
					gbl_panel_1.rowWeights = new double[] { 0.0, 1.0,
							Double.MIN_VALUE };
					panel_1.setLayout(gbl_panel_1);
					{
						JLabel lblSelectCategories = new JLabel("Select Categories");
						makeBigLabel(lblSelectCategories);
						GridBagConstraints gbc_lblSelectCategories = new GridBagConstraints();
						gbc_lblSelectCategories.anchor = GridBagConstraints.WEST;
						gbc_lblSelectCategories.insets = new Insets(0, 0, 5, 5);
						gbc_lblSelectCategories.gridx = 0;
						gbc_lblSelectCategories.gridy = 0;
						panel_1.add(lblSelectCategories, gbc_lblSelectCategories);
					}
					{
						JButton button = new JButton();
						button.setIcon(SwingUtils.getIcon("add.png"));
						GridBagConstraints gbc_button = new GridBagConstraints();
						gbc_button.insets = new Insets(0, 0, 5, 5);
						gbc_button.gridx = 1;
						gbc_button.gridy = 0;
						panel_1.add(button, gbc_button);
					}
					{
						JButton btnE = new JButton();
						btnE.setIcon(SwingUtils.getIcon("edit.png"));
						GridBagConstraints gbc_btnE = new GridBagConstraints();
						gbc_btnE.insets = new Insets(0, 0, 5, 0);
						gbc_btnE.gridx = 2;
						gbc_btnE.gridy = 0;
						panel_1.add(btnE, gbc_btnE);
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						GridBagConstraints gbc_scrollPane = new GridBagConstraints();
						gbc_scrollPane.gridwidth = 3;
						gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
						gbc_scrollPane.fill = GridBagConstraints.BOTH;
						gbc_scrollPane.gridx = 0;
						gbc_scrollPane.gridy = 1;
						panel_1.add(scrollPane, gbc_scrollPane);
						{
							JList list = new JList();
							scrollPane.setViewportView(list);
						}
					}
				}
			}
			{
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.insets = new Insets(0, 0, 0, 5);
				gbc_panel_2.gridx = 1;
				gbc_panel_2.gridy = 0;
				panel.add(panel_2, gbc_panel_2);
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[] { 0, 0 };
				gbl_panel_2.rowHeights = new int[] { 0, 0 };
				gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
				gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
				panel_2.setLayout(gbl_panel_2);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
					panel_1.setBackground(Color.WHITE);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
					panel_2.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[] { 128, 64, 0, 0 };
					gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
					gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0,
							Double.MIN_VALUE };
					gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
							0.0, Double.MIN_VALUE };
					panel_1.setLayout(gbl_panel_1);
					{
						JLabel lblFont = new JLabel("Font");
						makeBigLabel(lblFont);
						GridBagConstraints gbc_lblFont = new GridBagConstraints();
						gbc_lblFont.anchor = GridBagConstraints.WEST;
						gbc_lblFont.gridwidth = 3;
						gbc_lblFont.insets = new Insets(0, 0, 5, 0);
						gbc_lblFont.gridx = 0;
						gbc_lblFont.gridy = 0;
						panel_1.add(lblFont, gbc_lblFont);
					}
					{
						cmbxFontNames = new JComboBox();
						GridBagConstraints gbc_cmbxFontNames = new GridBagConstraints();
						gbc_cmbxFontNames.insets = new Insets(0, 0, 5, 5);
						gbc_cmbxFontNames.fill = GridBagConstraints.HORIZONTAL;
						gbc_cmbxFontNames.gridx = 0;
						gbc_cmbxFontNames.gridy = 1;
						panel_1.add(cmbxFontNames, gbc_cmbxFontNames);
					}
					{
						cmbxFontSizes = new JComboBox();
						GridBagConstraints gbc_cmbxFontSizes = new GridBagConstraints();
						gbc_cmbxFontSizes.insets = new Insets(0, 0, 5, 5);
						gbc_cmbxFontSizes.fill = GridBagConstraints.HORIZONTAL;
						gbc_cmbxFontSizes.gridx = 1;
						gbc_cmbxFontSizes.gridy = 1;
						panel_1.add(cmbxFontSizes, gbc_cmbxFontSizes);
					}
					{
						btnFontColor = new JButton();
						btnFontColor.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Color newColor = JColorChooser.showDialog(
					                     SettingsPane.this,
					                     "Choose Background Color",
					                     btnFontColor.getBackground());
								btnFontColor.setBackground(newColor);
							}
						});
						btnFontColor.setBackground(Color.BLACK);
						GridBagConstraints gbc_btnFontColor = new GridBagConstraints();
						gbc_btnFontColor.fill = GridBagConstraints.BOTH;
						gbc_btnFontColor.insets = new Insets(0, 0, 5, 0);
						gbc_btnFontColor.gridx = 2;
						gbc_btnFontColor.gridy = 1;
						panel_1.add(btnFontColor, gbc_btnFontColor);
					}
					{
						JLabel lblFontDisplay = new JLabel("Font Display");
						GridBagConstraints gbc_lblFontDisplay = new GridBagConstraints();
						gbc_lblFontDisplay.insets = new Insets(0, 0, 5, 0);
						gbc_lblFontDisplay.anchor = GridBagConstraints.WEST;
						gbc_lblFontDisplay.gridwidth = 3;
						gbc_lblFontDisplay.gridx = 0;
						gbc_lblFontDisplay.gridy = 2;
						panel_1.add(lblFontDisplay, gbc_lblFontDisplay);
					}
					{
						JLabel lblTransparency = new JLabel("Transparency");
						makeBigLabel(lblTransparency);
						GridBagConstraints gbc_lblTransparency = new GridBagConstraints();
						gbc_lblTransparency.insets = new Insets(0, 0, 5, 0);
						gbc_lblTransparency.anchor = GridBagConstraints.WEST;
						gbc_lblTransparency.gridwidth = 3;
						gbc_lblTransparency.gridx = 0;
						gbc_lblTransparency.gridy = 3;
						panel_1.add(lblTransparency, gbc_lblTransparency);
					}
					{
						transparencySlider = new JSlider();
						transparencySlider.setOpaque(false);
						GridBagConstraints gbc_transparencySlider = new GridBagConstraints();
						gbc_transparencySlider.fill = GridBagConstraints.HORIZONTAL;
						gbc_transparencySlider.gridwidth = 3;
						gbc_transparencySlider.insets = new Insets(0, 0, 0, 5);
						gbc_transparencySlider.gridx = 0;
						gbc_transparencySlider.gridy = 4;
						panel_1.add(transparencySlider, gbc_transparencySlider);
					}
				}
			}
			{
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.gridx = 2;
				gbc_panel_2.gridy = 0;
				panel.add(panel_2, gbc_panel_2);
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[] { 78, 0 };
				gbl_panel_2.rowHeights = new int[] { 0, 0 };
				gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_panel_2.rowWeights = new double[] { 1.0,
						Double.MIN_VALUE };
				panel_2.setLayout(gbl_panel_2);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
					panel_1.setBackground(Color.WHITE);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
					panel_2.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[]{0, 0};
					gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
					gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
					gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_1.setLayout(gbl_panel_1);
					{
						JLabel lblMessage = new JLabel("Message...");
						makeBigLabel(lblMessage);
						GridBagConstraints gbc_lblMessage = new GridBagConstraints();
						gbc_lblMessage.anchor = GridBagConstraints.WEST;
						gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
						gbc_lblMessage.gridx = 0;
						gbc_lblMessage.gridy = 0;
						panel_1.add(lblMessage, gbc_lblMessage);
					}
					{
						JRadioButton rdbtnOrdered = new JRadioButton("Ordered");
						rdbtnOrdered.setOpaque(false);
						GridBagConstraints gbc_rdbtnOrdered = new GridBagConstraints();
						gbc_rdbtnOrdered.anchor = GridBagConstraints.WEST;
						gbc_rdbtnOrdered.insets = new Insets(0, 0, 5, 0);
						gbc_rdbtnOrdered.gridx = 0;
						gbc_rdbtnOrdered.gridy = 1;
						panel_1.add(rdbtnOrdered, gbc_rdbtnOrdered);
					}
					{
						JRadioButton rdbtnRandom = new JRadioButton("Random");
						rdbtnRandom.setOpaque(false);
						GridBagConstraints gbc_rdbtnRandom = new GridBagConstraints();
						gbc_rdbtnRandom.anchor = GridBagConstraints.WEST;
						gbc_rdbtnRandom.gridx = 0;
						gbc_rdbtnRandom.gridy = 2;
						panel_1.add(rdbtnRandom, gbc_rdbtnRandom);
					}
				}
			}
		}
	}
	
	private void makeBigLabel(JLabel lbl) {
		lbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
	}
}
