package designpatterns.second.triangle;

public class RightAngledTriangle extends Triangle {
	private double side1;
	private double side2;
	
	public RightAngledTriangle(double side1, double side2){
		super(side1, side2, Math.sqrt((side1*side1 + side2*side2)));
		this.side1 = side1;
		this.side2 = side2;
	}

	@Override
	public double getArea() {
		return side1*side2/2;
	}
	
	
}
