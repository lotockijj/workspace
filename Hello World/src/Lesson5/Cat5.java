package Lesson5;
/* ������� ����� Cat
������� ����� Cat (���) � ����� ��������������:
- ���,
- ���, ���, �������
- ���, ������� (��� �����������)
- ���, ����, (���, ����� � ������� � �����������. ��� - ���������)
- ���, ����, ����� ( ����� �������� ���)
������ ������������ � ������� ������ ��������. ��������, ���� ��� �� ��������, �� ����� ������� �����-������ ������� ���. ��� �� ����� ������ �� ������. �� �� ���������� ��������. � ��� ����� ����� � �� ���� (null). �� �� �������� ������: null.
*/
public class Cat5{
	String name;
	int weight = 2;
	int age = 1;
	String color;
	String adress; 
	public Cat5(String name){
		this.name = name;
	}
	public Cat5(String name, int weight, int age){
		this.name = name;
		this.weight = weight;
		this.age = age; 
	}
	public Cat5(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Cat5(int weight, String color){
		this.weight = weight;
		this.color = color;
	}
	public Cat5(int weight, String color, String adress){
		this.weight = weight;
		this.color = color;
		this.adress = adress; 
	}
	
	
	
    //�������� ��� ��� ���

}
