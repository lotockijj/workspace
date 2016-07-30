package JavaRush;
/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Ekauls{
public static void main(String[] args) throws Exception{
	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	String s1 = reader.readLine();
	String s2 = reader.readLine();
	 try {
	    Integer i1 = Integer.valueOf(s1);
	    Integer i2 = Integer.valueOf(s2);
	   
	   
	    if (i1<i2){
	    	System.out.print(i1);
	    }else {
	    	System.out.print(i2);
	    } 
	    }catch (NumberFormatException e) {
	    System.err.println("Неверный формат строки!");
    //напишите тут ваш код
	    }
	}

}