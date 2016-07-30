package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/
public class ThreePlus {
	 public static void main(String[] args) throws Exception {
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String s1 = reader.readLine();
	        String s2 = reader.readLine();
	        String s3 = reader.readLine();
	        int i1 = Integer.parseInt(s1);
	        int i2 = Integer.parseInt(s2);
	        int i3 = Integer.parseInt(s3);
	        int m = 0; 
	        if (i1>0){
	        	m =1; 
	        }
	        if (i2>0){
	        	m = m + 1; 
	        }
	        if (i3>0){
	        	m = m + 1; 
	        }
	        System.out.println(m);
	    }
	 }


