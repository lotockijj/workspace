package JavaRush9;
/* ���������� ��� ������ � ���������
����������� ���������� (� ������� ��� �� �����), ������ ��� ���, ����������� ��� ���������� ����:
int[] m = new int[2]; m[8] = 5;
*/

public class Solution2{
    public static void main(String[] args) throws Exception{
        try{
    	//�������� ��� ��� ���

        int[] m = new int[2];
        m[8]= 5;
        } catch (ArrayIndexOutOfBoundsException e){
        	System.out.println(e);
        }

        //�������� ��� ��� ���

    }
}
