package JavaRush;

/* ���� ������
������ � ���������� ����� ��� ������, � ����������� �� ������ ������� �������� ������������, ��������, ������, ��������, ��������, ��������, ������������,
���� ������ ����� ������ ��� ������ 7 � ������� ������� ��� ������ �� ����������.
������ ��� ������ 5:
�������
������ ��� ������ 10:
������ ��� ������ �� ����������
*/

import java.io.*;

public class Monday{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = Integer.parseInt(s);
        if(i==1){
        	System.out.println("�����������");
        }
        if(i==2){
        	System.out.println("�������");
        }
        if(i==3){
        	System.out.println("�����");
        }
        if(i==4){
        	System.out.println("�������");
        }
        if(i==5){
        	System.out.println("�������");
        }
        if(i==6){
        	System.out.println("�������");
        }
        if(i==7){
        	System.out.println("�����������");
        } if(i<1 || i>7){
        	System.out.println("������ ��� ������ �� ����������");
        }
        //�������� ��� ��� ���
    }
}