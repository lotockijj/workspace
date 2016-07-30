package JavaRush9;
import java.io.IOException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution14 {
    public static void main(String[] args) {
        processExceptions(new Solution14());

    }

    public static void processExceptions(Solution14 obj) {
      try {
    obj.method1();
// Момент 2
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
    // Момент 3
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
