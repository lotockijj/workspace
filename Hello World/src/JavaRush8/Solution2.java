package JavaRush8;

import java.util.HashMap;
import java.util.Map;

/* HashMap из 10 пар
—оздать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - €года, банан - трава, вишн€ - €года, груша - фрукт, дын€ - овощ, ежевика - куст, жень-шень - корень, земл€ника - €года, ирис - цветок, картофель - клубень.
¬ывести содержимое коллекции на экран, каждый элемент с новой строки.
ѕример вывода (тут показана только одна строка):
картофель - клубень
*/
public class Solution2{
    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("арбуз", "€года");
        map.put("банан", "трава");
        map.put("вишн€", "€года");
        map.put("груша", "фрукт");
        map.put("дын€", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земл€ника", "€года");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");
        for (Map.Entry<String, String> pair : map.entrySet()){
        	String key = pair.getKey(); 
        	String value = pair.getValue();
        	System.out.println(key + "-" + value);
        }
    	//напишите тут ваш код
    }
}