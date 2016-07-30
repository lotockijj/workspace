/* ������������ ��������
������ � ���������� ��� ����� �����, ������� ����� ������������ �����, �� ������� �� ������������ ���� OX � OY.
������� �� ����� ����� ������������ ��������, � ������� ��������� ������ �����.
���������:
�������������� ����� � ������������ (a,b) � ����� �� ��������� ������������ ��������� �������:
��� ������ �������� a>0 � b>0;
��� ������ �������� a<0 � b>0;
��� ������� �������� a<0 � b<0;
��� ��������� �������� a>0 � b<0.
������ ��� ����� 4 6:
1
������ ��� ����� -6 -6:
3
*/
import java.io.*;
public class Solution{
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	String s2 = reader.readLine();
    	 try {
    	    Integer i1 = Integer.valueOf(s1);
    	    Integer i2 = Integer.valueOf(s2);
    	    if (i1>0 && i2>0){
    	    	System.out.print(1);
    	    }else if(i1<0 && i2>0){
    	    	System.out.print(2);
    	    }else if(i1<0 && i2<0){
    	    	System.out.print(3);
    	    } else if (i1>0 && i2<0){
    	    	System.out.print(4);
    	    }
    	    }catch (NumberFormatException e) {
    	    System.err.println("�������� ������ ������!");
        //�������� ��� ��� ���
    	    }
    	}
 
   }