import java.util.*;

/**
 * Created by Роман Лотоцький on 26.05.2016.
 */
public class setCollection {
	public static void main(String[] args){
		NavigableSet<Integer> set = new TreeSet<>();
		for(int i = 0; i < 10; i++){
			set.add(i);
		}
		int toElement = 2; 
		int e = 5; 
		int fromElement = 7; 
		System.out.println("set.lower(5)= " + set.lower(e));
		System.out.println("set.higher(5)= " + set.higher(e));
		System.out.println("set.headSet(2)= " + set.headSet(toElement));
		System.out.println("set.tailSet(7)= " + set.tailSet(fromElement));
		System.out.println("set.descendingIterator()= " + set.descendingIterator().toString());
	}
}