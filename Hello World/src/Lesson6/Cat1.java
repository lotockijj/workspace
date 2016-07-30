package Lesson6;
/* ������ Cat � Dog � ����� finalize ��� �������
� ������ ������ Cat � Dog �������� ����� finalize, ������� ������� �� ����� ����� � ���, ��� �����-�� ������ ���������.
*/

public class Cat1{ 
   @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("Cat destroyed");
    }
}

class Dog{
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("Dog destroyed");
    }
}
