package Lesson6;
/* �� 50 000 �������� Cat � Dog
������� � ����� �� 50 000 �������� Cat � Dog. (Java-������ ������ ������ ���������� ��������������, � ����� finalize ���� ��� �� ���������).
*/

public class Cat2{
    public static void main(String[] args){
        for(int i = 0; i<50000; i++){
            //Cat a = new Cat();
            //Dog d = new Dog(); 
        }
        //�������� ��� ��� ���
    }
}
/*class Cat{
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
*/