package JavaRush9;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
/* ����������
���� �����, ������� ����������� ��� ����������, �������������� �� Exception, � ��� �������������� �� RuntimeException:
NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException.
����� ����������� NullPointerException � FileNotFoundException, �� �� �������������
ArithmeticException � URISyntaxException. ��� ��� �������?
*/
public class Solution11{
    public static void main(String[] args) throws Exception{
        //�������� ��� ��� ���
    	try{
        method1();
    	} catch (NullPointerException e){
    		System.out.println(e);
    	} 
    	catch (FileNotFoundException e){
    		System.out.println(e);
    	}
        //�������� ��� ��� ���
    }
    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException{
        int i = (int) (Math.random() * 4);
        if (i == 0)
            throw new NullPointerException();
        if (i == 1)
            throw new ArithmeticException();
        if (i == 2)
            throw new FileNotFoundException();
        if (i == 3)
            throw new URISyntaxException("", "");
    }
}
