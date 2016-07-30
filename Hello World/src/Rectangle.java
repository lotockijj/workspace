
public class Rectangle {
	
	private int x, y;
	private int width, height;
	
	public Rectangle(){
		this(0, 0, 1, 1);
	}
	
	public Rectangle(int width, int height){
		this(0, 0, width, height);
	} 
	
	public Rectangle(int x, int y, int wibth, int height){
		this.x = x;
		this.y = y;
		this.width = wibth;
		this.height = height;
	}

}
