package JavaRush8;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* »змерить сколько времени занимает 10 тыс€ч вызовов get дл€ каждого списка
»змерить, сколько времени занимает 10 тыс€ч вызовов get дл€ каждого списка.
ћетод getTimeMsOfGet  должен вернуть врем€ его исполнени€ в миллисекундах.
*/
public class Solution120{
    public static void main(String[] args){
        System.out.println(getTimeMsOfGet(fill(new ArrayList())));
        System.out.println(getTimeMsOfGet(fill(new LinkedList())));
    }
    private static List fill(List list){
        for(int i = 0; i < 11; i++){
            list.add(new Object());
        }
        return list;
    }
    public static long  getTimeMsOfGet(List list){
    	Date a = new Date();
        //напишите тут ваш код

        get10000(list);
        	Date b = new Date();
        	long c = b.getTime() - a.getTime();
        	return c; 
        //напишите тут ваш код

    }
    public static void get10000(List list){
        if (list.isEmpty()) return;
        int x = list.size() / 2;

        for (int i = 0; i < 10000; i++){
            list.get(x);
        }
    }
}

