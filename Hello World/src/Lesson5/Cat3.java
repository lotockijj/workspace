package Lesson5;

/* ������� ����� Cat
������� ����� Cat (���) � ����� ����������������:
- ���,
- ���, ���, �������
- ���, ������� (��� �����������)
- ���, ����, (���, ����� � ������� ����������, ��� ��������� ���)
- ���, ����, ����� ( ����� �������� ���)
������ �������������� � ������� ������ ��������. ��������, ���� ��� ����������, �� ����� ������� �����-������ ������� ���. ��� �� ����� ������ �� ������. �� �� ���������� ��������. � ��� ����� ����� � �� ���� (null). �� �� �������� ������: null.
*/

public class Cat3{
    public String name;
    public int weight;
    public int age;
    public String color;
    public String adress; 
    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
    }
    public void initialize(int weight, String color, String adress ){
        this.weight = weight;
        this.color = color;
        this.adress = adress;
    }
    //�������� ��� ��� ���
}