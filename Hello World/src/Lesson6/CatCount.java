package Lesson6;
/* C������ �����
� ������������ ������ Cat [public Cat()] ����������� ������� ����� (����������� ���������� ����� �� ������ catCount) �� 1. � ������ finalize ��������� �� 1.
*/

public class CatCount{
    public static int catCount = 0;
    public CatCount (){
        catCount++;
    }

    protected void finalize() throws Throwable {
       catCount--;
    }
    //�������� ��� ��� ���

    public static void main(String[] args) {
    }
}

