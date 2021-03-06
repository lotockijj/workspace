package MindCastr.image;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

  private Image backgroundImage;
  public Background(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, null);
  }
}