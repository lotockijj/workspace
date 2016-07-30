package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/
public class Solution3{
    public static void main(String[] args) throws Exception{
    	String [] a = new String[10]; 
    	int [] b = new int[10];
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i<10; i++){
    		String d = reader.readLine();
    		a[i] = d; 
    	}
    	for(int i = 0; i<10; i++){
    		b[i] = a[i].length();
    		System.out.println(b[i]);
    	}
    	
        //напишите тут ваш код

    }
}
