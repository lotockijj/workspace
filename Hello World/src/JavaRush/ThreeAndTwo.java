package JavaRush;
/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeAndTwo{
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	String s2 = reader.readLine();
    	String s3 = reader.readLine();
    	    Integer i1 = Integer.valueOf(s1);
    	    Integer i2 = Integer.valueOf(s2);
    	    Integer i3 = Integer.valueOf(s3);
    	   
    	    if (i1==i2){
    	    	System.out.print(3);
    	    	
    	    }else if(i1==i3){
    	    	System.out.print(2);
    	    }else if(i2==i3){
    	    	System.out.print(1);//напишите тут ваш код
    	    }
     }
}
 
   