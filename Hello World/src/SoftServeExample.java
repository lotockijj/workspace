import java.io.Serializable;
import java.util.List;

/**
 * Created by roman on 20.07.16.
 */

//todo fix languge level problem
public class SoftServeExample {
	static List<Rectangle> list;
	static Rectangle r1;

	static public class Rectangle implements Serializable {
		public final float side1;
		public final float side2;

		public Rectangle(float side1, float side2) {
			this.side1 = side1;
			this.side2 = side2;
		}

		public float getArea() {
			return side1 * side2;
		}

		public float getPerimeter() {
			return 2 * side1 + 2 * side2;
		}

		@Override
		public String toString() {
			return "Rectangle (" + side1 + " x " + side2 + ")";
		}
	}
}