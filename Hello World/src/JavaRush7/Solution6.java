package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ќдин большой массив и два маленьких
1. —оздать массив на 20 чисел.
2. ¬вести в него значени€ с клавиатуры.
3. —оздать два массива на 10 чисел каждый.
4. —копировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. ¬ывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution6{
    public static void main(String[] args) throws Exception{
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int[] list = new int[20];
             for (int i = 0; i<list.length; i++){
                 String s = reader.readLine();
                 list[i] = Integer.parseInt(s);
                 }
         int[] list2 = new int[10];
         for (int a = 0; a<list.length/2; a++){
         list2[a] = list[a];
         }
         int[] list3 = new int[10];
         for (int c = list.length/2, a = 0;c<list.length; c++, a++){
             list3[a] = list[c];
         }
         for (int s = 0; s<list3.length; s++){
             System.out.println(list3[s]);
         }
     }
 }