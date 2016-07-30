package JavaRush8;
/* ћетод должен возвращать результат Ц глубину его стек-трейса
Ќаписать метод, который возвращает результат Ц глубину его стек трейса Ц количество методов 
в нем (количество элементов в списке). Ёто же число метод должен выводить на экран.
*/

public class Solution131{
    public static int getStackTraceDeep(){
    	 StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         int a = stackTraceElements.length;
         System.out.println(a);
         return a;
        //напишите тут ваш код
    }
}
