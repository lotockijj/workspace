package calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalculatorGUI implements ActionListener{
	
	JFrame frame = new JFrame("Calculator");
	JPanel panel = new JPanel(new FlowLayout());
	JTextArea text = new JTextArea(1, 15);
	JButton but1 = new JButton("1");
	JButton but2 = new JButton("2");
	JButton butAdd = new JButton("+");
	JButton buteq = new JButton("=");
	JButton butclear = new JButton("clear");
	
	Double number1, number2, result;
	int addc = 0, subc = 0, multyc = 0, divc = 0;
	
	
	public void createGui(){
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(text);
		panel.add(but1);
		panel.add(but2);
		panel.add(butAdd);
		panel.add(buteq);
		panel.add(butclear);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		butAdd.addActionListener(this);
		buteq.addActionListener(this);
		butclear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == butclear){
			number1 = 0.0;
			number2 = 0.0;
			text.setText("");
			
			
		}
		
		if(src == but1){
			text.append("1");
		}
		if(src == but2){
			text.append("2");
		}
		if(src == butAdd){ // in order to read first number... 
			number1 = number_reader();
			text.setText("");
			addc = 1;
			subc = 0;
			multyc = 0;
			divc = 0;
		}
		if(src == buteq){
			number2 = number_reader();
			if(addc > 0){
				result = number1 + number2;
				text.setText(Double.toString(result));
			}
		}
		
	}
	
	public double number_reader(){
		Double num1;
		String s;
		s = text.getText();
		num1 = Double.valueOf(s);
		return num1;
	}
	
	public static void main(String[] args){
		CalculatorGUI calc = new CalculatorGUI();
		calc.createGui();
	}

}
