package JavaRush;
/* ������������� � ������������� �����
������ � ���������� ��� ����� �����. ������� �� ����� ���������� ������������� � ���������� ������������� ����� � �������� ������,
� ��������� ����:
"���������� ������������� �����: �", "���������� ������������� �����: �", ��� �, � - ������� ��������.
������ ��� ����� 2 5 6:
���������� ������������� �����: 0
���������� ������������� �����: 3
������ ��� ����� -2 -5 6:
���������� ������������� �����: 2
���������� ������������� �����: 1
*/

import java.io.*;

public class Solution10{
	 public static void main(String[] args) throws Exception {
	    	/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String s1 = reader.readLine();
	        String s2 = reader.readLine();
	        String s3 = reader.readLine();
	        int i1 = Integer.parseInt(s1);
	        int i2 = Integer.parseInt(s2);
	        int i3 = Integer.parseInt(s3);
	        int b = 0; 
	        int a = 0; 
	        */
		 Solution10JOP r = new Solution10JOP(); 
		 r.Scan(); 
		 r.i = count(r.i1, r.i2, r.i3);
		 
		 r.Scan(r.i1, r.i2, r.i3);
	 }
	private static int count(int x, int y, int z) {
		int c = 0; 
		if (x > 0){
			c++;
		} 
		if (y > 0){
			c++;
		
		} 
		if (z > 0){
			c++;
		} 
		return c; 
	}
}


