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

public class OdnoznachneLetters{
    public static void main(String[] args) throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String snum = reader.readLine();
        int r = Integer.parseInt(snum);
        if (r>1&&r<999){
            if (r%2==0&&snum.length()==1){
            	System.out.println("������ ����������� �����");
            }
            if (r%2==0&&snum.length()==2){
            	System.out.println("������ ���������� �����");
            }
            if (r%2==0&&snum.length()==3){
            	System.out.println("������ ����������� �����");
            }
            if (!(r%2==0)&&snum.length()==1){
            	System.out.println("�������� ����������� �����");
            }
            if (!(r%2==0)&&snum.length()==2){
            	System.out.println("�������� ���������� �����");
            }
            if (!(r%2==0)&&snum.length()==3){
            	System.out.println("�������� ����������� �����");//�������� ��� ��� ���
            }
        } 
    }
 }
    	

    

