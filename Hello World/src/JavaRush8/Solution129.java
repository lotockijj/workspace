package JavaRush8;

/* ����� ������ ������� ����� ������ ����, �� �������� ������� ���� �����
�������� ���� �������, ������� �������� ���� �����. ����� ������ ������� ����� ������ ����, �� �������� ������� ���� �����. ������������ ��������: element.getLineNumber().
*/

public class Solution129{
    public static void main(String[] args) throws Exception{
        method1();
    }

    public static int method1(){
        method2();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber()/*add your code here*/ ;
    }

    public static int method2(){
        method3();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber()/*add your code here*/ ;
    }

    public static int method3(){
        method4();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber()/*add your code here*/ ;
    }

    public static int method4(){
        method5();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber()/*add your code here*/ ;
    }

    public static int method5(){
        return  Thread.currentThread().getStackTrace()[2].getLineNumber() /*add your code here*/ ;
    }
}
