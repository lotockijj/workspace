package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* —ортировка трех чисел
¬вести с клавиатуры три числа, и вывести их в пор€дке убывани€.
*/
public class Solution {

	public static void main(String[] args) throws Exception{
	    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	    	String s1 = reader.readLine();
	    	String s2 = reader.readLine();
	    	String s3 = reader.readLine();
	    	
	    	 try {
	    	    Integer i1 = Integer.valueOf(s1);
	    	    Integer i2 = Integer.valueOf(s2);
	    	    Integer i3 = Integer.valueOf(s3);
	    	   
	    	    if (i1<i2 && i2<i3){
	    	    	System.out.print(i3);
	    	    	System.out.print(i2);
	    	    	System.out.print(i1);
	    	    }else if(i1<i3 && i3<i2){
	    	    	System.out.print(i2);
	    	    	System.out.print(i3);
	    	    	System.out.print(i1);
	    	    }else if(i2<i1 && i1<i3){
	    	    	System.out.print(i3);
	    	    	System.out.print(i1);
	    	    	System.out.print(i2);
	    	    } else if (i2<i3 && i3<i1){
	    	    	System.out.print(i1);
	    	    	System.out.print(i3);
	    	    	System.out.print(i2);
	    	    }else if(i3<i1 && i2<i1){
	    	    	System.out.print(i1);
	    	    	System.out.print(i2);
	    	    	System.out.print(i3);
	    	    }else if(i3<i2 && i1<i2){
	    	    	System.out.print(i2);
	    	    	System.out.print(i1);
	    	    	System.out.print(i3);
	    	    } 
	    	    }catch (NumberFormatException e) {
	    	    System.err.println("Ќеверный формат строки!");
	        //напишите тут ваш код
	    	    }
	    	}
	 
	   }