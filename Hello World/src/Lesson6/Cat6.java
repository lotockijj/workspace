package Lesson6;
/* ����������� ������: int getCatCount() � setCatCount(int)
��������  � ������ Cat ��� ����������� ������: int getCatCount() � setCatCount(int), � ������� ������� ����� ��������/�������� ���������� ����� (���������� catCount)
*/

public class Cat6{
    private static int catCount = 0;

    public Cat6(){
        catCount++;
    }

    public static int getCatCount(){
        return catCount; 
        //�������� ��� ��� ���
    }
    public static void setCatCount(int catCount){
        Cat6.catCount = catCount; 
        //�������� ��� ��� ���
    }
}
