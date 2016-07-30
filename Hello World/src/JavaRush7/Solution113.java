package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/
public class Solution113{
    public static void main(String[] args) throws Exception{
        ArrayList<String> a = new ArrayList<String>();
        a.add("мама");
        a.add("мила");
        a.add("раму");
        for (int i = 0; i < a.size(); i++){
        	a.add( i, "именно");
        	i++; 
        }
        for (int i = 0; i < a.size(); i++){
        	System.out.println(a.get(i));
        }
    }
}
