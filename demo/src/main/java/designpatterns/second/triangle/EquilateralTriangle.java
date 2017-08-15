package designpatterns.second.triangle;

public class EquilateralTriangle extends Triangle{
	private double side;
	
	public EquilateralTriangle(double side){
		super(side, side, side);
		this.side = side;
	}

	@Override
	public double getArea() {
		return side*side/2;
	}

}
