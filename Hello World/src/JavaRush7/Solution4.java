package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ������ �� ����� � �������� �������
1. ������� ������ �� 10 �����.
2. ������ � ���������� 10 ����� � �������� �� � ������.
3. ����������� �������� ������� � �������� �������.
4. ������� ��������� �� �����, ������ �������� �������� � ����� ������.
*/

public class Solution4{
    public static void main(String[] args) throws Exception{
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int a[] = new int[2];
         int b[] = new int[2];

         for(int i = 0; i < a.length; i++)
             a[i] = Integer.parseInt(reader.readLine());

         for(int i = 0; i < a.length; i++){
             b[b.length -1 - i] = a[i];
         }
         a = b;
         for(int i : a)
             System.out.println(i);

     }
 }
   		//arr[i] = Integer.parseInt(reader.readLine());
    	