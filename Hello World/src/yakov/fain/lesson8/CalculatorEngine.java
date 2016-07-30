package yakov.fain.lesson8;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculatorEngine implements ActionListener{
	
	CalculatorTryIt parent; // a reference to the Calculator
	
	CalculatorEngine(CalculatorTryIt parent){
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = parent.getDisplayValue();
		String ckickedButtonLabel = clickedButton.getText();
		parent.setDisplayValue(dispFieldText + ckickedButtonLabel); 
		
	}
}
