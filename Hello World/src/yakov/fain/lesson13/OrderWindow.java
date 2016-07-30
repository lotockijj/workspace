package yakov.fain.lesson13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class OrderWindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel panel = new JPanel();

	String[] modelBikes = {"Model-123", "Aist-2", "Java-3", "Minsk-2", "Saturn-ss"}; 
	JButton validate = new JButton("Validate");
	JLabel txtResult = new JLabel();
	JComboBox<Object> comboList = new JComboBox<Object>(modelBikes);
	JTextField numberBikes = new JTextField(10);

	public OrderWindow() {
		panel.setLayout(new FlowLayout());

		panel.add(comboList);
		numberBikes.setText("");
		comboList.setEditable(false);
		panel.add(numberBikes);
		panel.add(validate);
		panel.add(txtResult);

		JFrame frame = new JFrame("Bikes");
		frame.setContentPane(panel);
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		comboList.addActionListener(this);
		validate.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e){
		// the user clicked on the “Validate Order” button
		Object src =  e.getSource();
		if(src == validate){
			try{
				BikeOrder bikeOrder = new BikeOrder();
				bikeOrder.validateOrder(comboList.getSelectedItem().toString(), 
						Integer.parseInt(numberBikes.getText()));
				// the next line will be skipped in case of exception
				

				txtResult.setText("Order is valid");
				txtResult.setForeground(Color.black);
			} catch(TooManyBikesException e1){
				txtResult.setText(e1.getMessage());
				txtResult.setForeground(Color.RED);
			}
		}
	}

}
