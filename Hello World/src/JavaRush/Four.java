package JavaRush;
/* ������� ������� �����
�������� �������, ������� ��������� ������� �� ������ �����.
������� min(a,b,c,d) ������ ������������ (��������) ������� min(a,b)
���������:
����� �������� ���� ����� ������������ ������� min � ��������� �� ������������ ��������.
*/
public class Four{
    public static int min(int a, int b, int c, int d) {
        int mainMin;
        int m2 = min(a,b);
        int m3 = min(c,d);
        if (m2<m3)
            mainMin = m2;
        else
            mainMin = m3;
        return mainMin;
        //�������� ��� ��� ���
    }
    public static int min(int a, int b) {
        int m1;
        if (a<b)
            m1=a;
        else
            m1=b;
        return m1;//�������� ��� ��� ���
    }
    public static void main(String[] args) throws Exception{
        System.out.println( min(-20, -10) );
        System.out.println( min(-20, -10, -30, -40) );
        System.out.println( min(-20, -10, -30, 40) );
    }
}