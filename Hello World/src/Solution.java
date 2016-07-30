/* Координатные четверти
Ввести с клавиатуры два целых числа, которые будут координатами точки, не лежащей на координатных осях OX и OY.
Вывести на экран номер координатной четверти, в которой находится данная точка.
Подсказка:
Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
Пример для чисел 4 6:
1
Пример для чисел -6 -6:
3
*/
import java.io.*;
public class Solution{
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	String s2 = reader.readLine();
    	 try {
    	    Integer i1 = Integer.valueOf(s1);
    	    Integer i2 = Integer.valueOf(s2);
    	    if (i1>0 && i2>0){
    	    	System.out.print(1);
    	    }else if(i1<0 && i2>0){
    	    	System.out.print(2);
    	    }else if(i1<0 && i2<0){
    	    	System.out.print(3);
    	    } else if (i1>0 && i2<0){
    	    	System.out.print(4);
    	    }
    	    }catch (NumberFormatException e) {
    	    System.err.println("Неверный формат строки!");
        //напишите тут ваш код
    	    }
    	}
 
   }