package Lesson6;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ����� ConsoleReader
������� ����� ConsoleReader, � �������� ����� 4 ����������� ������:
String readString() � ������ � ���������� ������
int readInt() � ������ � ���������� �����
double readDouble() � ������ � ���������� ������� �����
boolean readBoolean() � ������ � ���������� ������ "true" ��� "false" � ���������� ��������������� ���������� ���������� true ��� false
��������: ���������� ���������� ��� ������ ������ � ������� (BufferedReader ��� Scanner) ������ ������� ������
*/
public class Cat8{
    public static String readString() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s; 
        //�������� ��� ��� ���
    }

    public static int readInt() throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int m = Integer.parseInt(s1);
        return m; 
        //�������� ��� ��� ���
    }

    public static double readDouble() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        double v = Double.parseDouble(s1);
        return v; 
        //�������� ��� ��� ���
    }

    public static boolean readBoolean() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        boolean n = Boolean.parseBoolean(s1);
        return n;
        //�������� ��� ��� ���
    }
}

