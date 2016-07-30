package Lesson5;
/* ����������� ����� fight
����������� ����� boolean fight(Cat anotherCat):
����������� �������� ����� ����� � ����������� �� �� ����, �������� � ����.
����������� ��������� ������. ����� ������ ����������, �������� �� �� (this) ��� ��� ���,
�.�. ���������� true, ���� �������� � false - ���� ���.
������ ����������� �������:
���� cat1.fight(cat2) = true , �� cat2.fight(cat1) = false
*/

public class Cat1{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat1(){
    }

    public boolean fight(Cat anotherCat){
       int incAge = this.age>anotherCat.age ? 1:0;
       int incWeight = this.weight>anotherCat.weight ? 1:0;
       int incStrength = this.strength>anotherCat.strength ? 1:0;
       return (incAge+incWeight+incStrength)>0; //�������� ��� ��� ���
    }
}