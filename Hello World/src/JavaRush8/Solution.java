package JavaRush8;
import java.util.HashSet;
import java.util.Set;
/* HashSet �� ��������
������� ��������� HashSet � ����� ��������� String.
�������� � �� 10 �����: �����, �����, �����, �����, ����, �������, ����-����, ���������, ����, ���������.
������� ���������� ��������� �� �����, ������ ������� � ����� ������.
����������, ��� ��������� ������� ����������� ���������.
*/
public class Solution{
    public static void main(String[] args) throws Exception{
        Set<String> set = new HashSet<String>();
        set.add("�����");
        set.add("�����");
        set.add("�����");
        set.add("�����");
        set.add("����");
        set.add("�������");
        set.add("����-����");
        set.add("���������");
        set.add("����");
        set.add("���������");
        for (String t : set){
        	System.out.println(t);
        }
    	//�������� ��� ��� ���
    }
}