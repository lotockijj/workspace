import java.io.*;
import java.util.Scanner;
public class Scannner {
	/* ���������� �������� ��������
	������ � ���������� ��� � ������� �������:
	name ������������ $5,000. ��-��-��!
	������: ����� ������������ $5,000. ��-��-��!
	*/

	    public static void main(String[] args) throws Exception
	    {
	        Scanner scanner = new Scanner(System.in);
	        
	        String name = scanner.nextLine(); 
	        String age = scanner.nextLine();
	        //�������� ��� ��� ���
	        System.out.println(name +" �������� ��� �� " + age + " ����. ��-��-��!");
	        scanner.close();
	    }
	}

