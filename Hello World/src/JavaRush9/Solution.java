package JavaRush9;
/* ���������� ��� ������ � �������
����������� ���������� (� ������� ��� �� �����), ������ ��� ���, ����������� ��� ���������� ����:
int a = 42 / 0;
*/
public class Solution{
    public static void main(String[] args) throws Exception{
        try{
            int a = 42 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
        //�������� ��� ��� ���
    }
}