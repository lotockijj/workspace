package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* ����� ������� ������
1. ������ ������ �����.
2. ������ � ���������� 5 ����� � ������ � ������.
3. ��������� ����, ����� ����� ������� ������ � ������.
4. ������ ��������� ������ �� �����.
5. ���� ����� ����� ���������, ������ ������ � ����� ������.
 */
public class Solution10{
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> a = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			String s = reader.readLine();
			a.add(i, s);
		}
		int m = 0;
		for(int i = 0; i < a.size(); i++){
			if(a.get(i).length()>=m){
				m = a.get(i).length();
			}
		}
		for(int i = 0; i < a.size(); i++){
			if(a.get(i).length()== m){
				System.out.println(a.get(i));
			}
		}
	}
} 

