package Lesson5;
/* ������� ��� ������� ���� Cat
� ������ main ������� ��� ������� ���� Cat � ��������� �� �������.
������������ ����� Cat �� ������ ������. ����� Cat ��������� �� ����.
*/

public class Cat2 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Marta", 1, 2, 3);
        Cat cat2 = new Cat("John", 4, 5, 6);
        Cat cat3 = new Cat("Adler", 7, 8, 9);
        System.out.println(cat1.name + " " + cat2.name + " " + cat3.name);
        //�������� ��� ��� ���
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
