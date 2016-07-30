package JavaRush;
/* —трока - описание
¬вести с клавиатуры целое число. ¬ывести на экран его строку-описание следующего вида:
Ђотрицательное четное числої - если число отрицательное и четное,
Ђотрицательное нечетное числої - если число отрицательное и нечетное,
Ђнулевое числої - если число равно 0,
Ђположительное четное числої - если число положительное и четное,
Ђположительное нечетное числої - если число положительное и нечетное.
ѕример дл€ числа 100:
положительное четное число
ѕример дл€ числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class LettersMark {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s = reader.readLine();
    	Integer s1 = Integer.valueOf(s); 
    	boolean d;
    	d = s1 % 2 == 0; 
    	
    	    	 try {
    	    		 if (d && s1<0){
    		 System.out.println("отрицательное четное число");
    	    	 } else if  (!d && s1<0){
    	    		 System.out.println("отрицательное нечетное число");
    	    	 } else if (d && s1==0){
    	    		 System.out.println("нулевое число");
    	    	 }else if (d && s1>0){
    	    		 System.out.println("положительное четное число");
    	    	 }else if (!d && s1>0){
    	    		 System.out.println("положительное нечетное число");
    	    	 }
    	    }catch (NumberFormatException e) {
    	    System.err.println("Ќеверный формат строки!");
        //напишите тут ваш код
    	    }
    	}

    }