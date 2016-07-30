package Swing;

import javax.swing.JFrame;

public class dick {
	public static void main(String args[]){
		Reader r = new Reader("Моє перше вікно!!!");
		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(500, 350);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
	}

}
