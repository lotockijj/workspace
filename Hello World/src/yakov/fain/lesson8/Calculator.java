package yakov.fain.lesson8;

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

public class Calculator implements ActionListener{

	public JPanel pane = new JPanel();

	public JButton button0, button1, button2, button3, button4, button5,
	button6,  button7, button8, button9, buttonPoint, buttonEqual,
	buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonBackSpace,
	buttonCE, buttonSQRT, buttonPercent, buttonOneDevide,
	buttonMC, buttonMR, buttonMPlus, buttonMMinus, buttonClear;

	public JTextField displayField;

	Object src;
	Double number1 = 0.0, suma = 0.0, result = 0.0;
	boolean function;
	State state = State.ZERO; 

	public Calculator() {
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
		c.gridx = 2;
		c.gridy = 2;
		pane.add(button1, c);

		button2 = new JButton("2");
		c.gridx = 3;
		c.gridy = 2;
		pane.add(button2, c);

		button3 = new JButton("3");
		c.gridx = 1;
		c.gridy = 3;
		pane.add(button3, c);

		button4 = new JButton("4");
		c.gridx = 2;
		c.gridy = 3;
		pane.add(button4, c);

		button5 = new JButton("5");
		c.gridx = 3;
		c.gridy = 3;
		pane.add(button5, c);

		button6 = new JButton("6");
		c.gridx = 1;
		c.gridy = 4;
		pane.add(button6, c);

		button7 = new JButton("7");
		c.gridx = 2;
		c.gridy = 4;
		pane.add(button7, c);

		button8 = new JButton("8");
		c.gridx = 3;
		c.gridy = 4;
		pane.add(button8, c);

		button9 = new JButton("9");
		c.gridx = 1;
		c.gridy = 5;
		pane.add(button9, c);

		buttonPoint = new JButton(".");
		c.gridx = 2;
		c.gridy = 5;
		pane.add(buttonPoint, c);

		buttonEqual = new JButton("=");
		c.gridx = 4;
		c.gridy = 2;
		pane.add(buttonEqual, c);

		buttonPlus = new JButton("+");
		c.gridx = 3;
		c.gridy = 5;
		pane.add(buttonPlus, c);

		buttonMinus = new JButton("−");
		c.gridx = 1;
		c.gridy = 6;
		pane.add(buttonMinus, c);

		buttonMultiply = new JButton("×");
		c.gridx = 2;
		c.gridy = 6;
		pane.add(buttonMultiply, c);

		buttonDivide = new JButton("/");
		c.gridx = 3;
		c.gridy = 6;
		pane.add(buttonDivide, c);

		buttonBackSpace = new JButton("BackSpace");
		c.gridx = 4;
		c.gridy = 3;
		pane.add(buttonBackSpace, c);

		buttonPercent = new JButton("%");
		c.gridx = 4;
		c.gridy = 6;
		pane.add(buttonPercent, c);

		buttonCE = new JButton("CE");
		c.gridx = 5;
		c.gridy = 2;
		pane.add(buttonCE, c);

		buttonSQRT = new JButton("SQRT");
		c.gridx = 4;
		c.gridy = 4;
		pane.add(buttonSQRT, c);

		buttonOneDevide = new JButton("1/x");
		c.gridx = 4;
		c.gridy = 5;
		pane.add(buttonOneDevide, c);

		buttonMMinus = new JButton("M-");
		c.gridx = 5;
		c.gridy = 3;
		pane.add(buttonMMinus, c);

		buttonMR = new JButton("MR");
		c.gridx = 5;
		c.gridy = 5;
		pane.add(buttonMR, c);

		buttonMPlus = new JButton("M+");
		c.gridx = 5;
		c.gridy = 4;
		pane.add(buttonMPlus, c);

		buttonMC = new JButton("MC");
		c.gridx = 5;
		c.gridy = 6;
		pane.add(buttonMC, c);

		buttonClear = new JButton("Clear");
		c.gridx = 6;
		c.gridy = 2;
		pane.add(buttonClear, c);

		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(pane);
		// Set the size of the window big enough to accomodate all controls
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
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
		buttonCE.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonMC.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMPlus.addActionListener(this);
		buttonMMinus.addActionListener(this);
		buttonMR.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonOneDevide.addActionListener(this);
		buttonPercent.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonPoint.addActionListener(this);
		buttonSQRT.addActionListener(this);
		buttonClear.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		src = e.getSource();
		try{
			while (true) {
				if (src == buttonMC) {
					displayField.setText("");
					suma = 0.0;
					break;
				}
				if (src == buttonMPlus) {
					suma += Double.parseDouble(displayField.getText());
					break;
				} else if (src == buttonMMinus) {
					suma -= Double.parseDouble(displayField.getText());
					break;
				} else if (src == buttonMR) {
					displayField.setText(suma.toString());
					function = true;
					break;
				}
				if (src == buttonOneDevide) {
					displayField.setText(Double.toString(1 / Double.parseDouble(displayField.getText())));
					defaultData();
					break;
				}
				if (src == buttonSQRT) {
					displayField.setText(Double.toString(Math.sqrt(Double.parseDouble(displayField.getText()))));
					defaultData();
					break;
				}
				if(src == buttonEqual && state == State.EQUALS){ //  // if user pushed to times button "=" one times after another... line 353  
					break;
				}
				if(state == State.EQUALS && (isNumber(src) || src == buttonPoint)){
					function = true;
				}

				if (function) {
					displayField.setText("");
					function = false;
				}
				if (isNumber(src)) {
					JButton b = (JButton) src;
					displayField.setText(displayField.getText() + b.getText());
					result = numberReader();
					break;
				}
				if(src == buttonPoint && displayField.getText().indexOf('.') < 0){
					displayField.setText(displayField.getText() + ".");
					result = numberReader();
					break;
				}

				if (src == buttonBackSpace && displayField.getText().length() > 0) {
					displayField.setText(displayField.getText().substring(0, displayField.getText().length() - 1));
				}
				if (src == buttonClear || src == buttonCE) {
					displayField.setText("");
					defaultData();
				}

				if(src == buttonPercent){
					if(state == State.PLUS || state == State.MINUS) result = number1*result/100;
					if(state == State.MULTIPLY || state == State.DIVIDE) result = result/100;
				}

				if (isFunction(src)) {
					function = true;
					if(     state == State.PLUS   || state == State.MINUS || 
							state == State.DIVIDE || state == State.MULTIPLY){
						if (state == State.PLUS) {
							System.out.println(((JButton)src).getLabel() == state.toString());
							result = state.apply(result, number1); //result = result + number1;
						}
						if (state == State.MINUS) {
							result = state.apply(number1, result);//result = number1 - result;
						}
						if (state == State.MULTIPLY) {
							result = state.apply(number1, result);//result = number1 * result;
						}
						if (state == State.DIVIDE) {
							result = state.apply(number1, result); //result = number1 / result;
						}
						displayField.setText(result.toString());
						state = State.ZERO;
					}
					if (src == buttonEqual) {
						displayField.setText(result.toString());
						number1 = Double.parseDouble(displayField.getText());
						defaultData();
					}
					if (src == buttonPlus){ state = State.PLUS; number1 = Double.parseDouble(displayField.getText());}
					if (src == buttonMinus){ state = State.MINUS; number1 = Double.parseDouble(displayField.getText());}
					if (src == buttonMultiply){ state = State.MULTIPLY; number1 = Double.parseDouble(displayField.getText());}
					if (src == buttonDivide) {state = State.DIVIDE; number1 = Double.parseDouble(displayField.getText());}
				}
				break;
			}
		} catch (NumberFormatException e1) {
			System.out.println(e1);
		}

	}

	private double numberReader(){
		return Double.valueOf(displayField.getText());
	}

	private boolean isNumber(Object src){
		function = false;
		return  src == button0 || src == button1 || src == button2 ||
				src == button3 || src == button4 || src == button5 ||
				src == button6 || src == button7 || src == button8 ||
				src == button9;
	}

	private boolean isFunction(Object src){
		return  src == buttonDivide ||   src == buttonEqual ||     src == buttonMinus ||
				src == buttonMultiply || src == buttonPercent ||   src == buttonPlus;
	}
	private void defaultData(){
		result = 0.0;
		function = false;
		state = State.ZERO;
		if(src == buttonEqual){
			state = State.EQUALS; // when user pushed to times button "=" one times after another...  line 252
		}
		number1 = 0.0;
	}

	public static void main(String[] args){
		Calculator calc = new Calculator();
	}
}