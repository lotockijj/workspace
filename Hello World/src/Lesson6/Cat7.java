package Lesson6;
/* ����� Util
����������� ����������� ����� double getDistance(x1, y1, x2, y2). �� ������ ��������� ���������� ����� �������.
��������� ����� double Math.sqrt(double a), ������� ��������� ���������� ������ ����������� ���������
*/

public class Cat7{
    public static double getDistance(int x1, int y1, int x2, int y2){
              return Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))); 
         //�������� ��� ��� ���

    }
    public static void main(String[] args){
    	
    	System.out.println(Cat7.getDistance(3, 1, 6, 6));
    }
}
