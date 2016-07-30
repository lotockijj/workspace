package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* ��� �������
1. ����� � ���������� 20 �����, ������� �� � ������ � ����������� �� ��� ������ �������:
����� ������� �� 3 (x%3==0), ������� �� 2 (x%2==0) � ��� ���������.
�����, ������� ������� �� 3 � �� 2 ������������, �������� 6, �������� � ��� ������.
2. ����� printList ������ �������� �� ����� ��� �������� ������ � ����� ������.
3. ��������� ����� printList ������ ��� ��� ������ �� �����. ������� ���, ������� ��� x%3, ����� ���, ������� ��� x%2, ����� ���������.
 */
public class Solution111{
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i = 0; i < 20; i++){
			String s = reader.readLine();
			int s1 = Integer.parseInt(s);
			a.add(i, s1);
		}
		for(int i = 0; i <a.size(); i++){
			if( a.get(i)%3 ==0){
				a3.add(a.get(i));
			} else if(a.get(i)%2 ==0){
				a2.add(a.get(i));
			}else if( a.get(i)%6 == 0){
				a3.add(a.get(i));
				a2.add(a.get(i));
			} 
			else if( (a.get(i)%3 != 0) & (a.get(i)%2 != 0) ){
				ar.add(a.get(i));
			}
		}
		printList(a3); 
		printList(a2);
		printList(ar); 
	}

	public static void printList(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
