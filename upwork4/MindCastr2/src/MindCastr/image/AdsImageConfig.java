package MindCastr.image;

/**
 *
 * @author Alex
 */
public class AdsImageConfig {
      int width;
      int hight;
      String imageName;
      int x;
      int y;

      public AdsImageConfig(int width, int hight, String imageName, int x, int y) {
          this.width = width;
          this.hight = hight;
          this.imageName = imageName;
          this.x = x;
          this.y = y;
      }

      public int getHight() {
          return hight;
      }

      public String getImageName() {
          return imageName;
      }

      public int getWidth() {
          return width;
      }

      public int getX() {
          return x;
      }

      public int getY() {
          return y;
      }
      
}
