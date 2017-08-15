package designpatterns.second.triangle;

public abstract class Triangle {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double side1, double side2, double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getPerimiter(){
		return side1 + side2 + side3;
	}
	
	public abstract double getArea();

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}
	
	

}
