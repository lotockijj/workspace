package JavaRush8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* ������� ��� ����� ������ 10
������� ��������� �����(Set<Integer>), ������� ���� 20 ��������� �����.
������� �� ��������� ��� ����� ������ 10.
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