package JavaRush;
/* ������ - ��������
������ � ���������� ����� ����� � ��������� 1 - 999. ������� ��� ������-�������� ���������� ����:
������� ����������� ����� - ���� ����� ������ � ����� ���� �����,
��������� ����������� ����� - ���� ����� �������� � ����� ���� �����,
������� ���������� ����� - ���� ����� ������ � ����� ��� �����,
��������� ���������� ����� - ���� ����� �������� � ����� ��� �����,
������� ����������� ����� - ���� ����� ������ � ����� ��� �����,
��������� ����������� ����� - ���� ����� �������� � ����� ��� �����.
���� ��������� ����� �� �������� � �������� 1 - 999, � ����� ������ ������ �� �������� �� �����.
������ ��� ����� 100:
������ ����������� �����
������ ��� ����� 51:
�������� ���������� �����
*/

import java.io.*;

public class NinthNinthNinth{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String snum = reader.readLine();
        int num = Integer.parseInt(snum);
        if (num>=1&&num<999){
        	if (num%2==0&&snum.length()==1)System.out.println("������ ����������� �����");
            if (num%2==0&&snum.length()==2)System.out.println("������ ���������� �����");
            if (num%2==0&&snum.length()==3)System.out.println("������ ����������� �����");
            if (!(num%2==0)&&snum.length()==1)System.out.println("�������� ����������� �����");
            if (!(num%2==0)&&snum.length()==2)System.out.println("�������� ���������� �����");
            if (!(num%2==0)&&snum.length()==3)System.out.println("�������� ����������� �����");
          //�������� ��� ��� ���
        }
    } 

}


