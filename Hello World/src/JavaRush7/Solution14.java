package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 10 ������� � ������ ������
1. ������ ������ ����� � ������ main.
2. ������ � ���� 10 ������� � ����������, �� ������ ��������� �� � ����� ������, � � ������.
3. ��������� ���� ������ ���������� �� �����, ������ �������� � ����� ������.
*/
public class Solution14{
    public static void main(String[] args) throws Exception{
    	ArrayList<String> a = new ArrayList<String>();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i < 10; i++){
    		String s = reader.readLine();
    		a.add( 0, s);
    	}
    	for(int i = 0; i < 10; i++){
    		System.out.println(a.get(i));
    	}
        //�������� ��� ��� ���

    }
}
