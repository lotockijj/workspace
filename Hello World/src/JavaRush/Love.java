package JavaRush;
/* ��� ����� �����
������ � ���������� ��� � ��������� ���� for 10 ��� �������: [*���* ����� ����.]
������ ������:
����� ����� ����.
����� ����� ����.
�
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Love{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String s1 = reader.readLine();
    	for(int i = 0; i<10; i++){
    	System.out.printf("%s ����� ����.", s1);
    	System.out.println();
    	}
        //�������� ��� ��� ���
    }
}

