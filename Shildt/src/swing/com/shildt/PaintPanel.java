package swing.com.shildt;

//Paint lines to a panel.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//This class extends JPanel. It overrides the paintComponent() method so that random
//lines are plotted in the panel.
class PaintPanel extends JPanel {
	Insets ins; // holds the panel’s insets
	Random rand; // used to generate random numbers
	
	PaintPanel() { //Construct a panel.
		
		setBorder( //Put a border around the panel.
				BorderFactory.createLineBorder(Color.RED, 5));
		rand = new Random();
	}
	
	protected void paintComponent(Graphics g) { //Override the paintComponent() method. 
		
		super.paintComponent(g); //Always call the superclass method first.
		int x, y, x2, y2;
		
		int height = getHeight(); //Get the height and width of the component.
		int width = getWidth();
		
		ins = getInsets(); //Get the insets.
		
		for(int i=0; i < 10; i++) { //Draw ten lines whose endpoints are randomly generated.
			
			
			x = rand.nextInt(width-ins.left);    // Obtain random coordinates that define
			y = rand.nextInt(height-ins.bottom); // the endpoints of each line.
			x2 = rand.nextInt(width-ins.left);
			y2 = rand.nextInt(height-ins.bottom);
			
			g.drawLine(x, y, x2, y2); // Draw the line.
		}
	}
}

