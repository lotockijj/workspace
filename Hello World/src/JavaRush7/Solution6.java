package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ���� ������� ������ � ��� ���������
1. ������� ������ �� 20 �����.
2. ������ � ���� �������� � ����������.
3. ������� ��� ������� �� 10 ����� ������.
4. ����������� ������� ������ � ��� ���������: �������� ����� � ������ ���������, ������ �������� �� ������ ���������.
5. ������� ������ ��������� ������ �� �����, ������ �������� �������� � ����� ������.
*/

public class Solution6{
    public static void main(String[] args) throws Exception{
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int[] list = new int[20];
             for (int i = 0; i<list.length; i++){
                 String s = reader.readLine();
                 list[i] = Integer.parseInt(s);
                 }
         int[] list2 = new int[10];
         for (int a = 0; a<list.length/2; a++){
         list2[a] = list[a];
         }
         int[] list3 = new int[10];
         for (int c = list.length/2, a = 0;c<list.length; c++, a++){
             list3[a] = list[c];
         }
         for (int s = 0; s<list3.length; s++){
             System.out.println(list3[s]);
         }
     }
 }