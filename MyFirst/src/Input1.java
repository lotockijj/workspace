	/* ������� - ��� ������ �����
	������ � ���������� ��� ����� � ������� �������:
	name1 �������������� name2, � ��� ����� ��������� �������.
	������:
	���� �������������� ����, � ��� ����� ��������� �������.
	*/

	import java.util.Scanner;

	public class Input1{
	    public static void main(String[] args) throws Exception
	    {
	    	Scanner r = new Scanner(System.in); 
	    	String name1 = r.nextLine(); 
	    	String name2 = r.nextLine();
	    	System.out.println(name1 + "�������������� " + name2 + " � ��� ����� �������� �������.");
	        r.close();
	    	//�������� ��� ��� ���

	    }
	}
