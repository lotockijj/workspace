package JavaRush9;
import java.io.IOException;
/* Исключение при работе со строками
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
String s = null;
String m = s.toLowerCase();
*/
public class Solution1{
    public static void main(String[] args) throws Exception{
    	try{
        //напишите тут ваш код
        String s = null;
        String m = s.toLowerCase();
    	} catch (NullPointerException e){
    		System.out.println(e);
    	}
        //напишите тут ваш код
    }
}

