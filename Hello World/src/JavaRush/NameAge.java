package JavaRush;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;

public class NameAge{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	    	String name = reader.readLine();
	    	String age = reader.readLine();
            try {
	    	    Integer age1 = Integer.valueOf(age);
	    	    if (age1<18){
	    	        System.out.print("Подрасти еще");
	    	    }
	    	    
            }catch (NumberFormatException e) {
	    	    System.err.println("Неверный формат строки!");
	        //напишите тут ваш код
	    	    }
	    	}
	 
	   }