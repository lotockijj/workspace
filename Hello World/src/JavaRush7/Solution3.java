package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 2 �������
1. ������� ������ �� 10 �����.
2. ������� ������ �� 10 �����.
3. ������ � ���������� 10 �����, ��������� ��� ������ �����.
4. � ������ ������ ������� ����� �������� ����� ������ �� ������� �����, ������/����� ������ ������� ��������� � ������� �������� �� ������� �����. ������� ���������� ������� ����� �� �����, ������ �������� �������� � ����� ������.
*/
public class Solution3{
    public static void main(String[] args) throws Exception{
    	String [] a = new String[10]; 
    	int [] b = new int[10];
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i<10; i++){
    		String d = reader.readLine();
    		a[i] = d; 
    	}
    	for(int i = 0; i<10; i++){
    		b[i] = a[i].length();
    		System.out.println(b[i]);
    	}
    	
        //�������� ��� ��� ���

    }
}
