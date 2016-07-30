package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/
public class Solution114{
    public static void main(String[] args) throws Exception{
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list = fix(list);
        System.out.println(list);
        for (String s : list){
            System.out.println(s);
        }
    }
    public static ArrayList<String> fix(ArrayList<String> list){
    	for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).contains("р")) && !(list.get(i).contains("л"))) list.remove(i);
            if ((list.get(i).contains("л")) && !(list.get(i).contains("р")))list.add(i, list.get(i));
          }
           return null;
        
    }
}