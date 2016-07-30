package JavaRush8;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* Измерить сколько времени занимает 10 тысяч вставок для каждого списка
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert  должен вернуть время его исполнения в миллисекундах.
*/
public class Solution119{
    public static void main(String[] args){
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }
    public static long  getTimeMsOfInsert(List list){
        //напишите тут ваш код
    		Date a = new Date();
        insert10000(list);
        	Date b = new Date();
        	long c = b.getTime() - a.getTime();
        	return c; 
        //напишите тут ваш код

    }
    public static void insert10000(List list){
        for (int i=0;i<10000;i++){
            list.add(0, new Object());
        }
    }
}