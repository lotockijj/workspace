package JavaRush;
/* ������������� � ������������� �����
������ � ���������� �����. ���� ����� �������������, �� ��������� ��� � ��� ����. ���� ����� �������������, �� ��������� �������.
������� ��������� �� �����.
*/

import java.io.*;

public class Solution23{
    public static void main(String[] args) throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = Integer.parseInt(s);
        if (i>0){
        	i = i*2; 
        }
        if (i<1){
        	i = i + 1; 
        }
        System.out.println(i);
        //�������� ��� ��� ���

    }

}
