package yakov.fain.lesson10;

import java.applet.Applet;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorApplet extends Applet implements ActionListener{ // work only button "+"; 

	public JPanel pane = new JPanel();

	public JButton button0, button1, button2, button3, button4, button5,
	button6,  button7, button8, button9, buttonPoint, buttonEqual,
	buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonBackSpace,
	buttonC, buttonCE, buttonSQRT, buttonPercent, buttonOneDivide, 
	buttonMC, buttonMR, buttonMPlus, buttonMS, buttonMMinus, buttonClear;

	public JTextField displayField;

	Object src; 
	Double number1, number2, result = 0.0;
	int addc = 0, subc = 0, multyc = 0, divc = 0;


	public String getDisplayValue() {
		return displayField.getText();
	}

	public void setDisplayValue(String value) {
		displayField.setText(value);
	}

	public void init() {	
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		displayField = new JTextField("");
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = 7; 
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.CENTER;
		c.insets = new Insets(5, 5, 5, 5);
		pane.add(displayField, c);

		button0 = new JButton("0");
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1; 
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.CENTER;
		pane.add(button0, c);

		button1 = new JButton("1");
		c.gridx = 1; 
		c.gridy = 3;
		pane.add(button1, c);

		button2 = new JButton("2");
		c.gridx = 1;
		c.gridy = 4;
		pane.add(button2, c);

		button3 = new JButton("3");
		c.gridx = 1; 
		c.gridy = 5;
		pane.add(button3, c);

		button4 = new JButton("4");
		c.gridx = 1;
		c.gridy = 6;
		pane.add(button4, c);

		button5 = new JButton("5");
		c.gridx = 2;
		c.gridy = 2;
		pane.add(button5, c);

		button6 = new JButton("6");
		c.gridx = 2;
		c.gridy = 3;
		pane.add(button6, c);

		button7 = new JButton("7");
		c.gridx = 2;
		c.gridy = 4;
		pane.add(button7, c);

		button8 = new JButton("8");
		c.gridx = 2;
		c.gridy = 5;
		pane.add(button8, c);

		button9 = new JButton("9");
		c.gridx = 2;
		c.gridy = 6;
		pane.add(button9, c);

		buttonPoint = new JButton(".");
		c.gridx = 3;
		c.gridy = 2;
		pane.add(buttonPoint, c);

		buttonEqual = new JButton("=");
		c.gridx = 3;
		c.gridy = 3;
		pane.add(buttonEqual, c);

		buttonPlus = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		pane.add(buttonPlus, c);

		buttonMinus = new JButton("--");
		c.gridx = 3;
		c.gridy = 5;
		pane.add(buttonMinus, c);

		buttonMultiply = new JButton("*");
		c.gridx = 3;
		c.gridy = 6;
		pane.add(buttonMultiply, c);

		buttonDivide = new JButton("/");
		c.gridx = 4;
		c.gridy = 2;
		pane.add(buttonDivide, c);

		buttonBackSpace = new JButton("BackSpace");
		c.gridx = 4;
		c.gridy = 3;
		pane.add(buttonBackSpace, c);

		buttonC = new JButton("C");
		c.gridx = 4;
		c.gridy = 4;
		pane.add(buttonC, c);

		buttonCE = new JButton("CE");
		c.gridx = 4;
		c.gridy = 5;
		pane.add(buttonCE, c);

		buttonSQRT = new JButton("SQRT");
		c.gridx = 4;
		c.gridy = 6;
		pane.add(buttonSQRT, c);

		buttonPercent = new JButton("%");
		c.gridx = 5;
		c.gridy = 1;
		pane.add(buttonPercent, c);

		buttonOneDivide = new JButton("1/x");
		c.gridx = 5;
		c.gridy = 2;
		pane.add(buttonOneDivide, c);

		buttonMC = new JButton("MC");
		c.gridx = 5;
		c.gridy = 3;
		pane.add(buttonMC, c);

		buttonMR = new JButton("MR");
		c.gridx = 5;
		c.gridy = 4;
		pane.add(buttonMR, c);

		buttonMPlus = new JButton("M+");
		c.gridx = 5;
		c.gridy = 5;
		pane.add(buttonMPlus, c);

		buttonMS = new JButton("MS");
		c.gridx = 5;
		c.gridy = 6;
		pane.add(buttonMS, c);

		buttonMMinus = new JButton("M-");
		c.gridx = 6;
		c.gridy = 1;
		pane.add(buttonMMinus, c);

		buttonClear = new JButton("Clear");
		c.gridx = 6;
		c.gridy = 2;
		pane.add(buttonClear, c);

		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(pane);
		// Set the size of the window big enough to accomodate all controls
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		buttonBackSpace.addActionListener(this);
		buttonC.addActionListener(this);
		buttonCE.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonMC.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMPlus.addActionListener(this);
		buttonMR.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonOneDivide.addActionListener(this);
		buttonPercent.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonPoint.addActionListener(this);
		buttonSQRT.addActionListener(this);
		buttonClear.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src =  e.getSource();
		if(addc == 0){
			displayField.setText("");
			addc = 1;
		}
		if(     src == button0 || src == button1 || src == button2 ||
				src == button3 || src == button4 || src == button5 ||
				src == button6 || src == button7 || src == button8 ||
				src == button9 || src == buttonPoint){
			if(src == button0){
				displayField.setText(displayField.getText() + "0");
			}
			if(src == button1){
				displayField.setText(displayField.getText() + "1");
			}
			if(src == button2){
				displayField.setText(displayField.getText() + "2");
			}
			if(src == button3){
				displayField.setText(displayField.getText() + "3");
			}
			if(src == button4){
				displayField.setText(displayField.getText() + "4");
			}
			if(src == button5){
				displayField.setText(displayField.getText() + "5");
			}
			if(src == button6){
				displayField.setText(displayField.getText() + "6");
			}
			if(src == button7){
				displayField.setText(displayField.getText() + "7");
			}
			if(src == button8){
				displayField.setText(displayField.getText() + "8");
			}
			if(src == button9){
				displayField.setText(displayField.getText() + "9");
			}
			if(src == buttonPoint && displayField.getText().indexOf('.') < 0){
				displayField.setText(displayField.getText() + ".");
			}
		}
		if(src == buttonBackSpace && displayField.getText().length() > 0){
			System.out.println("BackSpace work");
			displayField.setText(displayField.getText().substring(0, displayField.getText().length() - 1));
		}
		if(src == buttonClear){
			displayField.setText("");
			result = 0.0;
		}

		if(src == buttonPlus){
			number1 = numberReader();
			if(addc == 0) {
				result = number1;
			}
			number1 = 0.0;
			subc = 0;
		}

		if(     src == buttonDivide || src == buttonEqual || src == buttonMinus ||
				src == buttonMultiply || src == buttonOneDivide || src == buttonPercent ||
				src == buttonPlus || src == buttonSQRT && addc == 1 ){
			if(addc >= 0){
				number2 = numberReader();
				result = result + number2;
				displayField.setText(Double.toString(result));
				addc = 0;
				number2 = 0.0;
			}
		}

	}

	public double numberReader(){
		Double num1;
		String s;
		s = displayField.getText();
		num1 = Double.valueOf(s);
		return num1;
	}

}

