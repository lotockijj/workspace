package JavaRush9;

import java.util.HashMap;
/* ���������� ��� ������ � ����������� Map
����������� ���������� (� ������� ��� �� �����), ������ ��� ���, ����������� ��� ���������� ����:
HashMap<String, String> map = new HashMap<String, String>(null);
map.put(null, null);
map.remove(null);
*/
public class Solution4{
    public static void main(String[] args) throws Exception{
        //�������� ��� ��� ���
    	try{
        HashMap<String, String> map = new HashMap<String, String>(null);
        map.put(null, null);
        map.remove(null);
    	} catch( NullPointerException e){
    		System.out.println(e);
    	}
        //�������� ��� ��� ���
    }
}
