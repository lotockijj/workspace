package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
 */
public class Solution10{
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> a = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			String s = reader.readLine();
			a.add(i, s);
		}
		int m = 0;
		for(int i = 0; i < a.size(); i++){
			if(a.get(i).length()>=m){
				m = a.get(i).length();
			}
		}
		for(int i = 0; i < a.size(); i++){
			if(a.get(i).length()== m){
				System.out.println(a.get(i));
			}
		}
	}
} 

