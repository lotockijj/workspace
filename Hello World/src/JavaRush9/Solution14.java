package JavaRush9;
import java.io.IOException;
import java.rmi.RemoteException;

/* �������� checked ����������
� ������ processExceptions ����������� ��� checked ����������.
����� ������� �� ����� ������ ��������� checked ����������.
����� ������������ ������ ���� ���� try..
*/

public class Solution14 {
    public static void main(String[] args) {
        processExceptions(new Solution14());

    }

    public static void processExceptions(Solution14 obj) {
      try {
    obj.method1();
// ������ 2
    obj.method2();
    obj.method3();
    }
    catch (RemoteException e) {
        System.out.println(e);
    }
    catch (NoSuchFieldException e)
    {
        System.out.println(e);
    }
    catch (IOException e) {
        System.out.println(e);
    }
    // ������ 3
    }


    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
