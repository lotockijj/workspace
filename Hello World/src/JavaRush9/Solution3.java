package JavaRush9;
import java.util.ArrayList;
/* ���������� ��� ������ � ����������� List
����������� ���������� (� ������� ��� �� �����), ������ ��� ���, ����������� ��� ���������� ����:
ArrayList<String> list = new ArrayList<String>();
String s = list.get(18);
*/
public class Solution3{
    public static void main(String[] args) throws Exception{
        //�������� ��� ��� ���
    	try{
        ArrayList<String> list = new ArrayList<String>();
        String s = list.get(18);
    	} catch (IndexOutOfBoundsException e){
    		System.out.println(e);
    	}
        //�������� ��� ��� ���
    }
}