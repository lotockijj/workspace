package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* ������ �� ������� � �������� �������
1. ������� ������ �� 10 �������.
2. ������ � ���������� 8 ������� � ��������� �� � ������.
3. ������� ���������� ����� ������� (10 ���������) �� ����� � �������� �������. ������ ������� - � ����� ������.
*/
public class Solution2{
    public static void main(String[] args) throws Exception{
    	String [] a = new String[10];
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i<(a.length - 2); i++){
    		a[i] = reader.readLine();
    	}
    	for(int i = 0; i<10; i++){
   	        System.out.println(a[10 -1 - i]); // gnihtemos
    	}
    	
        //�������� ��� ��� ���

    }
}
