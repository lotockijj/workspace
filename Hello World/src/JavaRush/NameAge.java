package JavaRush;

/* 18+
������ � ���������� ��� � �������. ���� ������� ������ 18 ������� ������� ��������� ���.
*/

import java.io.*;

public class NameAge{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	    	String name = reader.readLine();
	    	String age = reader.readLine();
            try {
	    	    Integer age1 = Integer.valueOf(age);
	    	    if (age1<18){
	    	        System.out.print("�������� ���");
	    	    }
	    	    
            }catch (NumberFormatException e) {
	    	    System.err.println("�������� ������ ������!");
	        //�������� ��� ��� ���
	    	    }
	    	}
	 
	   }