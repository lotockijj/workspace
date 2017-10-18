package ekkel;

public abstract class Shape {

	public static String doDraw(Shape shape){
		return shape.draw();
	}
	
	public static String doErase(Shape shape){
		return shape.erase();
	}
	
	public abstract String draw();
	
	public abstract String erase();
}
