import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String ClickecButtonLabel = clickedButton.getText();
		JOptionPane.showConfirmDialog(null, "You pressed  " ,
				 ClickecButtonLabel, JOptionPane.PLAIN_MESSAGE);
	}
}
