package JavaRush8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/
public class Solution123{
    public static HashSet<Integer> createSet(){
        HashSet<Integer> a = new HashSet<>();
        for(int i = 0; i < 20; i++)
            a.add(i);
        return a;
    }
    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set){
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            if(it.next() > 10)
                it.remove();
        }
        return set;
    }
}