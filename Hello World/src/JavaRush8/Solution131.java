package JavaRush8;
/* ����� ������ ���������� ��������� � ������� ��� ����-������
�������� �����, ������� ���������� ��������� � ������� ��� ���� ������ � ���������� ������� 
� ��� (���������� ��������� � ������). ��� �� ����� ����� ������ �������� �� �����.
*/

public class Solution131{
    public static int getStackTraceDeep(){
    	 StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         int a = stackTraceElements.length;
         System.out.println(a);
         return a;
        //�������� ��� ��� ���
    }
}
