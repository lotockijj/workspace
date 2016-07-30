package JavaRush;
import java.io.*;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution24{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);
        if(i1==i2 && !(i2==i3)){
        	System.out.println(i1 + " " + i2);
        } else if(i1==i3 && !(i2==i3)){
        	System.out.println(i1 + " " + i3);
        } else if(i2==i3 && !(i1==i3)){
        	System.out.println(i2 + " " + i3);
        } else if(i1==i2 && i1==i3){
        	System.out.println(i1 + " " + i2 + " " +i3);
        }
        //напишите тут ваш код

    }
}