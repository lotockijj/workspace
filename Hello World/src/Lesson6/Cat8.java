package Lesson6;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/
public class Cat8{
    public static String readString() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s; 
        //напишите тут ваш код
    }

    public static int readInt() throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int m = Integer.parseInt(s1);
        return m; 
        //напишите тут ваш код
    }

    public static double readDouble() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        double v = Double.parseDouble(s1);
        return v; 
        //напишите тут ваш код
    }

    public static boolean readBoolean() throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        boolean n = Boolean.parseBoolean(s1);
        return n;
        //напишите тут ваш код
    }
}

