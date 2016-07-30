package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/
public class Solution2{
    public static void main(String[] args) throws Exception{
    	String [] a = new String[10];
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i<(a.length - 2); i++){
    		a[i] = reader.readLine();
    	}
    	for(int i = 0; i<10; i++){
   	        System.out.println(a[10 -1 - i]); // gnihtemos
    	}
    	
        //напишите тут ваш код

    }
}
