package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* ����� �������
1. ������ ������ �� ���� �����, �����, �����.
2. ����� ������� ����� ������ � ������ ������, ���������� ����� �������.
3. ��������� ���� for ������� ��������� �� �����, ������ ������� ������ � ����� ������.
*/
public class Solution113{
    public static void main(String[] args) throws Exception{
        ArrayList<String> a = new ArrayList<String>();
        a.add("����");
        a.add("����");
        a.add("����");
        for (int i = 0; i < a.size(); i++){
        	a.add( i, "������");
        	i++; 
        }
        for (int i = 0; i < a.size(); i++){
        	System.out.println(a.get(i));
        }
    }
}
