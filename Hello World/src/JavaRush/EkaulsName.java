package JavaRush;
/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class EkaulsName{
    public static void main(String[] args) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	String s1 = reader.readLine();
	String s2 = reader.readLine();
	 try {
		 System.out.println(s1.equals(s2));
	    }catch (NumberFormatException e) {
	    System.err.println("Неверный формат строки!");
    //напишите тут ваш код
	    }
	}

}