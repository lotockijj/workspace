package main.java.faberlic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLoginDialog extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JComboBox userComboBox;
	
	private FaberlicDAO faberlicDAO;
	private JTextField textField;
	private JTextField textField_1;
	
	public void setFaberlicDAO(FaberlicDAO theFaberlicDAO){
		faberlicDAO = theFaberlicDAO;
	}
	
	public void populateUsers(List<User> users){
		userComboBox.setModel(new DefaultComboBoxModel<>(users.toArray(new User[0])));
	}
	//create the dialog
	public UserLoginDialog(){
		GridBagLayout gridBL = new GridBagLayout();
		gridBL.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBL.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBL.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBL.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBL);
		
		JLabel lblUser = new JLabel("User");
		GridBagConstraints cUser = new GridBagConstraints();
		cUser.insets = new Insets(0, 0, 5, 5);
		cUser.gridwidth = 3;
		cUser.gridx = 0;
		cUser.gridy = 1;
		getContentPane().add(lblUser, cUser);
		
		textField = new JTextField();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 5, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		getContentPane().add(textField, c);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = new Insets(0, 0, 5, 5);
		c1.gridx = 1;
		c1.gridy = 3;
		getContentPane().add(lblPassword, c1);
		
		textField_1 = new JTextField();
		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(0, 0, 5, 0);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 3;
		c2.gridy = 3;
		getContentPane().add(textField_1, c2);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints c3 = new GridBagConstraints();
		c3.anchor = GridBagConstraints.NORTH;
		c3.insets = new Insets(0, 0, 5, 5);
		c3.gridx = 1;
		c3.gridy = 8;
		getContentPane().add(btnNewButton, c3);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints с4 = new GridBagConstraints();
		с4.insets = new Insets(0, 0, 5, 0);
		с4.gridx = 3;
		с4.gridy = 8;
		getContentPane().add(btnCancel, с4);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	

}
