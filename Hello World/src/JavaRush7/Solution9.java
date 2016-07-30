package JavaRush7;
import java.util.ArrayList;
/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution9{
    public static void main(String[] args) throws Exception{
    	ArrayList<String> a = new ArrayList<String>();
    	a.add("aaa");
    	a.add("sss");
    	a.add("asas");
    	a.add("fff");
    	a.add("d");
    	System.out.println(a.size());
    	for(int i = 0; i<a.size(); i++){
    		System.out.println(a.get(i));
    	}
        //напишите тут ваш код
    }
}
