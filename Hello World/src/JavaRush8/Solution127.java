package JavaRush8;

/* ������ ����� ������ ���������� ���� StackTrace
�������� ���� �������, ������� �������� ���� �����. ������ ����� ������ ���������� ���� StackTrace.
*/

public class Solution127{
    public static void main(String[] args) throws Exception{
        method1();
    }

    public static StackTraceElement[] method1(){
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements;
        
        //�������� ��� ��� ���

    }

    public static StackTraceElement[] method2(){
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements;
        //�������� ��� ��� ���

    }

    public static StackTraceElement[] method3(){
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements;
        //�������� ��� ��� ���

    }

    public static StackTraceElement[] method4(){
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements;
        //�������� ��� ��� ���

    }

    public static StackTraceElement[] method5(){
    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements; 
        //�������� ��� ��� ���

    }
}
