package JavaRush;
/* �����������
������ � ���������� ��� ����� �, b, c � ������� ��������������� ������������.
���������� ����������� ������������� ������������ �� ��������. ��������� ������� �� ����� � ��������� ����:
"����������� ����������." - ���� ����������� � ������ ��������� ����������.
"����������� �� ����������." - ���� ����������� � ������ ��������� �� ����������.
���������: ����������� ���������� ������ �����, ����� ����� ����� ���� ��� ������ ������ �������.
��������� �������� ������ ������� � ������ ���� ������.
���� ���� �� � ����� ������ ������� �������� ������ ����� ���� ������, �� ������������ � ������ ��������� �� ����������.
*/

import java.io.*;

public class Solution25 {
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);
        if((i1+i2)<=i3 || (i1+i3)<=i2 || (i2+i3)<=i1){
        	System.out.println("��������� ����.");
        } else{
        	System.out.println("��������� �� ����.");
        }
    }
}
