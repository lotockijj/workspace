package Lesson5;
/* —оздать класс пр€моугольник (Rectangle)
—оздать класс пр€моугольник (Rectangle). ≈го данными будут top, left, width, height (лева€ координата, верхн€€, ширина и высота). —оздать дл€ него как можно больше методов initialize(Е)
ѕримеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаЄм квадрат
-	создаЄм копию другого пр€моугольника (он и передаЄтс€ в параметрах)
*/

public class Rectangle {
    private int left;
    private int top;
    private int width = 0;
    private int height = 0;
    
    public void initialize(int left, int top, int width, int height){
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}
	public void initialize(int left, int top){
		this.left = left;
		this.top = top;
	}
	public void initialize(int left, int top, int width){
		this.left = left;
		this.top = top;
		this.width = width;
	}
	public void initialize(Rectangle rect){
        rect = this;
	}//напишите тут ваш код
	public int getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	public float getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}