package JavaRush9;
import java.io.IOException;
/* ���������� ��� ������ �� ��������
����������� ���������� (� ������� ��� �� �����), ������ ��� ���, ����������� ��� ���������� ����:
String s = null;
String m = s.toLowerCase();
*/
public class Solution1{
    public static void main(String[] args) throws Exception{
    	try{
        //�������� ��� ��� ���
        String s = null;
        String m = s.toLowerCase();
    	} catch (NullPointerException e){
    		System.out.println(e);
    	}
        //�������� ��� ��� ���
    }
}

