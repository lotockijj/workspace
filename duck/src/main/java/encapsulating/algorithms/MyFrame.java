package encapsulating.algorithms;

import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MyFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyFrame(String title){
		super(title);
		this.setSize(300, 300);
		this.setVisible(true);
	}

		public void paint(Graphics graphics){
		super.paint((java.awt.Graphics) graphics);
		String msg = "I rule !!!";
		graphics.drawString(msg, 100, 100);

	}
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("Head First Design Patterns");
	}
}