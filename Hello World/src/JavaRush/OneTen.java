package JavaRush;
/* �������� �� ������ �����
������ � ���������� ������ � ����� N.
������� �� ����� ������ N ��� ��������� ���� while.
������ �����:
���
2
������ ������:
���
���
*/
import java.io.*;
public class OneTen {
	 public static void main(String[] args) throws Exception {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 String s = reader.readLine();
		 String n = reader.readLine();
		 int n1 = Integer.parseInt(n);
		 while(n1>0){
			 System.out.println(s);
			 n1--; //�������� ��� ��� ���
		 }
	 }
}
