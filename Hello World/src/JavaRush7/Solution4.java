package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution4{
    public static void main(String[] args) throws Exception{
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int a[] = new int[2];
         int b[] = new int[2];

         for(int i = 0; i < a.length; i++)
             a[i] = Integer.parseInt(reader.readLine());

         for(int i = 0; i < a.length; i++){
             b[b.length -1 - i] = a[i];
         }
         a = b;
         for(int i : a)
             System.out.println(i);

     }
 }
   		//arr[i] = Integer.parseInt(reader.readLine());
    	