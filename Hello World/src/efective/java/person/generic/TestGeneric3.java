package efective.java.person.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestGeneric3 {

	// Returns the maximum value in a list - uses recursive type bound
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1000000);
		list.add(-10000000);
		System.out.println(max(list));
		
		List<String> listing = new ArrayList<>();
		listing.add("One");
		listing.add("Two");
		listing.add("Three");
		listing.add("Four");
		listing.add("AAA");
		listing.add("y");
		listing.add("II");
		System.out.println(max(listing));
	}
}
