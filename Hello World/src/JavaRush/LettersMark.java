package JavaRush;
/* ������ - ��������
������ � ���������� ����� �����. ������� �� ����� ��� ������-�������� ���������� ����:
�������������� ������ ����� - ���� ����� ������������� � ������,
�������������� �������� ����� - ���� ����� ������������� � ��������,
�������� ����� - ���� ����� ����� 0,
�������������� ������ ����� - ���� ����� ������������� � ������,
�������������� �������� ����� - ���� ����� ������������� � ��������.
������ ��� ����� 100:
������������� ������ �����
������ ��� ����� -51:
������������� �������� �����
*/

import java.io.*;

public class LettersMark {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s = reader.readLine();
    	Integer s1 = Integer.valueOf(s); 
    	boolean d;
    	d = s1 % 2 == 0; 
    	
    	    	 try {
    	    		 if (d && s1<0){
    		 System.out.println("������������� ������ �����");
    	    	 } else if  (!d && s1<0){
    	    		 System.out.println("������������� �������� �����");
    	    	 } else if (d && s1==0){
    	    		 System.out.println("������� �����");
    	    	 }else if (d && s1>0){
    	    		 System.out.println("������������� ������ �����");
    	    	 }else if (!d && s1>0){
    	    		 System.out.println("������������� �������� �����");
    	    	 }
    	    }catch (NumberFormatException e) {
    	    System.err.println("�������� ������ ������!");
        //�������� ��� ��� ���
    	    }
    	}

    }