package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* ”двой слова
1. ¬веди с клавиатуры 10 слов в список строк.
2. ћетод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. »спользу€ цикл for выведи результат на экран, каждое значение с новой строки.
*/
public class Solution222{
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
    	ArrayList<String> list = new ArrayList<String>();
    	for(int i = 0; i < 10; i++){
    		String s = reader.readLine();
    		list.add(s);
    	}
        //—читать строки с консоли и объ€вить ArrayList list тут
        ArrayList<String> result = doubleValues(list);
        for (String aResult : result)
            System.out.println(aResult);
    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i=0; i<list.size();) {
            list.add(i+1, list.get(i));
            i+=2;
        }
        return list;
    }
}