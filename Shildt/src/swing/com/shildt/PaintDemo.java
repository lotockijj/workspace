package swing.com.shildt;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class PaintDemo { // Demonstrate painting directly onto a panel.
	JLabel jlab;
	PaintPanel pp;
	PaintDemo() {
		
		JFrame jfrm = new JFrame("Paint Demo"); // Create a new JFrame container.
		
		jfrm.setSize(200, 150); // Give the frame an initial size.
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pp = new PaintPanel(); // Create the panel that will be painted.
		// Add the panel to the content pane. Because the default
		// border layout is used, the panel will automatically be
		// sized to fit the center region.
		jfrm.add(pp);
		
		jfrm.setVisible(true); // Display the frame.
	}
	
	public static void main(String args[]) { // Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PaintDemo();
			}
		});
	}
}
