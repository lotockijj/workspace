package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* ����� �� � ����� ��
1. ������ ������ ����, ������� ��� ��������������.
2. ����� fix ������:
2.1. ������� �� ������ ����� ��� �����, ���������� ����� ��
2.2. ��������� ��� ����� ���������� ����� ��.
2.3. ���� ����� �������� � ����� �� � ����� ��, �� �������� ��� ����� ��� ���������.
2.4. � ������� ������� ������ �� ������.
������:
����
����
����
�������� ������:
����
����
����
*/
public class Solution114{
    public static void main(String[] args) throws Exception{
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("����"); //0
        list.add("����"); //1
        list.add("����"); //2
        list = fix(list);
        System.out.println(list);
        for (String s : list){
            System.out.println(s);
        }
    }
    public static ArrayList<String> fix(ArrayList<String> list){
    	for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).contains("�")) && !(list.get(i).contains("�"))) list.remove(i);
            if ((list.get(i).contains("�")) && !(list.get(i).contains("�")))list.add(i, list.get(i));
          }
           return null;
        
    }
}