package JavaRush7;
import java.util.ArrayList;
/* 5 ��������� ������� � ������
1. ������ ������ �����.
2. ������ � ���� 5 ��������� �������.
3. ������ ��� ������ �� �����.
4. ��������� ���� ������ ��� ���������� �� �����, ������ �������� � ����� ������.
*/
public class Solution9{
    public static void main(String[] args) throws Exception{
    	ArrayList<String> a = new ArrayList<String>();
    	a.add("aaa");
    	a.add("sss");
    	a.add("asas");
    	a.add("fff");
    	a.add("d");
    	System.out.println(a.size());
    	for(int i = 0; i<a.size(); i++){
    		System.out.println(a.get(i));
    	}
        //�������� ��� ��� ���
    }
}
