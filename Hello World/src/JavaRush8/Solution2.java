package JavaRush8;

import java.util.HashMap;
import java.util.Map;

/* HashMap �� 10 ���
������� ��������� HashMap<String, String>, ������� ���� 10 ��� �����:
����� - �����, ����� - �����, ����� - �����, ����� - �����, ���� - ����, ������� - ����, ����-���� - ������, ��������� - �����, ���� - ������, ��������� - �������.
������� ���������� ��������� �� �����, ������ ������� � ����� ������.
������ ������ (��� �������� ������ ���� ������):
��������� - �������
*/
public class Solution2{
    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("�����", "�����");
        map.put("�����", "�����");
        map.put("�����", "�����");
        map.put("�����", "�����");
        map.put("����", "����");
        map.put("�������", "����");
        map.put("����-����", "������");
        map.put("���������", "�����");
        map.put("����", "������");
        map.put("���������", "�������");
        for (Map.Entry<String, String> pair : map.entrySet()){
        	String key = pair.getKey(); 
        	String value = pair.getValue();
        	System.out.println(key + "-" + value);
        }
    	//�������� ��� ��� ���
    }
}