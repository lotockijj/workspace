package Swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Reader extends JFrame{
	JButton b1, b2; 
	JLabel l1, l2, l3, l4;
	JTextField t1, t2;
	int i, k;
	String a, b; 
	public Reader(String s){
		super(s);
		setLayout(new FlowLayout());
		b1 = new JButton("Додати");
		b2 = new JButton("Відняти");
		l1 = new JLabel("Поділити");
		l2 = new JLabel("Помножити");
		l3 = new JLabel("Залишок");
		l4 = new JLabel("Очистити");
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		add(b1);
		add(b2);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(t2); 
	}
}
