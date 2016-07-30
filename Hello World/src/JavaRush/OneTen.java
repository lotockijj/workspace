package JavaRush;
/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/
import java.io.*;
public class OneTen {
	 public static void main(String[] args) throws Exception {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 String s = reader.readLine();
		 String n = reader.readLine();
		 int n1 = Integer.parseInt(n);
		 while(n1>0){
			 System.out.println(s);
			 n1--; //напишите тут ваш код
		 }
	 }
}
