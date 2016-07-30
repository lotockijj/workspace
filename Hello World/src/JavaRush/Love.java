package JavaRush;
/* Все любят Мамбу
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: [*имя* любит меня.]
Пример текста:
Света любит меня.
Света любит меня.
…
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Love{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String s1 = reader.readLine();
    	for(int i = 0; i<10; i++){
    	System.out.printf("%s любит меня.", s1);
    	System.out.println();
    	}
        //напишите тут ваш код
    }
}

