package yakov.fain.lesson17;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyCustomizableGUI<E> extends Frame implements Serializable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("My castom grafical user interface !!! :)");
	JPanel panel = new JPanel(new GridLayout(1, 2, 20, 20));
	JPanel newPanel = new JPanel(new GridLayout(1, 3));
	JTextField text;
	JButton userButton = new JButton("User preferences.");
	JButton saveButton = new JButton("Save");
	JButton cancelButton = new JButton("Cancel");
	JOptionPane optionPane = new JOptionPane();

	JFrame frameWindow = new JFrame();
	JPanel panelWindow = new JPanel(new GridLayout(2, 3));
	JComboBox<?> dialog1, dialog2, dialog3;
	Vector<String> color = new Vector<>();
	Vector<String> font = new Vector<>();
	Vector fontSize = new Vector();


	public MyCustomizableGUI() throws IOException, ClassNotFoundException{
		frame.setSize(300, 100);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		FileInputStream fis = new FileInputStream("object.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		text = (JTextField) ois.readObject();
		System.out.println("Our employee - " + text.toString());
		panel.add(text);
		panel.add(userButton);

		userButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == userButton){
			makeFrameWindow();
		}
		if(src == saveButton){
			String getColor = String.valueOf(dialog1.getSelectedItem()); 
			String getFont =  String.valueOf(dialog2.getSelectedItem());
			int getFontSize = (int) dialog3.getSelectedItem();
			switch(getColor){
			case("green"): text.setForeground(Color.green);
			break;
			case("red"): text.setForeground(Color.red);
			break;
			case("blue"): text.setForeground(Color.blue);
			break;
			}
			Font f = new Font("BOLD", getFontSize, getFontSize); 
			switch(getFont){
			case("ITALIC"): f = new Font("ITALIC", getFontSize, getFontSize); 
			break;
			case("ROMAN_BASELINE"): f = new Font("ROMAN_BASELINE", getFontSize, getFontSize);
			break;
			case("SANS_SERIF"): f = new Font("SANS_SERIF", getFontSize, getFontSize);
			break;
			} 
			text.setFont(f);
			serializable(text);
			frameWindow.dispose();
		}
		if(src == cancelButton){
			dialog1.setSelectedIndex(0);
			dialog2.setSelectedIndex(0);
			dialog3.setSelectedIndex(0);
			String getColor = String.valueOf(dialog1.getSelectedItem());
			String getFont =  String.valueOf(dialog2.getSelectedItem());
			String getFontSize = String.valueOf(dialog3.getSelectedItem());
			System.out.println(getColor + " " + getFont + " " + getFontSize);
		}

	}

	private void serializable(JTextField text2) {
		FileOutputStream fOut=null;
		ObjectOutputStream oOut=null;
		
		File f = new File("object.txt");
		
		try{
			fOut = new FileOutputStream(f);
			oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(text2); //serializing employee
		} catch (IOException e){
			// close the streams
			try{
				oOut.flush();
				oOut.close();
				fOut.close();
			}catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
		System.out.println("The JTextFild text object has been serialized into " +
				"object.txt");
		
	}

	public void makeFrameWindow(){
		frameWindow.setVisible(true);
		frameWindow.setSize(300, 150);
		frameWindow.add(panelWindow);
		addColor();
		dialog1 = new JComboBox<>(color);
		addFont();
		dialog2 = new JComboBox<>(font);
		addFontSize();
		dialog3 = new JComboBox(fontSize);
		panelWindow.add(dialog1);
		panelWindow.add(dialog2);
		panelWindow.add(dialog3);
		panelWindow.add(saveButton);
		panelWindow.add(cancelButton);

		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);


	}

	public void addColor(){
		color.add("Select color");
		color.add("green");
		color.add("red");
		color.add("blue");
	}

	public void addFont(){
		font.add("Select font");
		font.add("ITALIC");
		font.add("ROMAN_BASELINE");
		font.add("SANS_SERIF");
	}

	public void addFontSize(){
		fontSize.add("Font size");
		fontSize.add(6);
		fontSize.add(18);
		fontSize.add(28);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MyCustomizableGUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
/*
if(findThreeInARow()){
String winnerName=
(playerName == PLAYERX)?PLAYERO:PLAYERX;
JOptionPane.showOptionDialog(this,
winnerName.concat(“ won!!! Congratulations!!!”),
“Congratulations!”, JOptionPane.YES_OPTION,
JOptionPane.PLAIN_MESSAGE, null, str, “OK”);
reset();
 */

