package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution14{
    public static void main(String[] args) throws Exception{
    	ArrayList<String> a = new ArrayList<String>();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i < 10; i++){
    		String s = reader.readLine();
    		a.add( 0, s);
    	}
    	for(int i = 0; i < 10; i++){
    		System.out.println(a.get(i));
    	}
        //напишите тут ваш код

    }
}
