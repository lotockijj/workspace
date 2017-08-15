package designpatterns.second.triangle;

public class Client {

	public static void main(String[] args) {
		Triangle triangle = new RightAngledTriangle(3, 4);
		showPerimeterAndArea(triangle);
		triangle = new EquilateralTriangle(5);
		showPerimeterAndArea(triangle);
	}

	private static void showPerimeterAndArea(Triangle triangle) {
		System.out.println(triangle);
		System.out.println("Perimeter: " + triangle.getPerimiter());
		System.out.println("Area:      " + triangle.getArea());
	}
}
