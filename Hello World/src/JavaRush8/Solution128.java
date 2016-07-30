package JavaRush8;

/* » снова StackTrace
Ќаписать п€ть методов, которые вызывают друг друга.  аждый метод должен возвращать им€ метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution128{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1(){
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements[2].getMethodName();
        //напишите тут ваш код

    }

    public static String method2(){
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements[2].getMethodName();
        //напишите тут ваш код

    }

    public static String method3(){
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements[2].getMethodName();
        //напишите тут ваш код

    }

    public static String method4(){
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements[2].getMethodName();
        //напишите тут ваш код

    }

    public static String method5(){
    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	return stackTraceElements[2].getMethodName(); 
        //напишите тут ваш код

    }
}
