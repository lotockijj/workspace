package Lesson5;

/* ������� ����� Friend
������� ����� Friend (����) � ����� ���������������� (����� �������� initialize):
- ���
- ���, �������
- ���, �������, ���
*/

public class Friends{
	private String filename = null;
	public void initialize(String name){
		this.filename = name; 
	}
	public void initialize(String name, String age){
		this.filename = name + age; 
	}
	public void initialize(String name, String age, String sex){
		this.filename = name + age + sex; 
	}
    //�������� ��� ��� ���
}
