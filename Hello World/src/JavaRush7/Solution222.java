package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* ����� �����
1. ����� � ���������� 10 ���� � ������ �����.
2. ����� doubleValues ������ ��������� ����� �� �������� a,b,c -> a,a,b,b,c,c.
3. ��������� ���� for ������ ��������� �� �����, ������ �������� � ����� ������.
*/
public class Solution222{
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
    	ArrayList<String> list = new ArrayList<String>();
    	for(int i = 0; i < 10; i++){
    		String s = reader.readLine();
    		list.add(s);
    	}
        //������� ������ � ������� � �������� ArrayList list ���
        ArrayList<String> result = doubleValues(list);
        for (String aResult : result)
            System.out.println(aResult);
    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i=0; i<list.size();) {
            list.add(i+1, list.get(i));
            i+=2;
        }
        return list;
    }
}