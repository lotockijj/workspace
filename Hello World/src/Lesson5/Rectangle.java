package Lesson5;
/* ������� ����� ������������� (Rectangle)
������� ����� ������������� (Rectangle). ��� ������� ����� top, left, width, height (����� ����������, �������, ������ � ������). ������� ��� ���� ��� ����� ������ ������� initialize(�)
�������:
-	������ 4 ���������: left, top, width, height
-	������/������ �� ������ (��� ����� 0)
-	������ �� ������ (����� ������) ������ �������
-	������ ����� ������� �������������� (�� � ��������� � ����������)
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
	}//�������� ��� ��� ���
	public int getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	public float getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}