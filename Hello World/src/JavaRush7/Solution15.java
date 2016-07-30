package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution15{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            a.add(s);
        }
        for (int i = 0; i < 13; i++){
            String s1 = a.get(4);
            a.add(0, s1);
        }
        for (int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}