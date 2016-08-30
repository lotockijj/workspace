package iterator2;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements iterator2.Iterator, Iterator  {

	ArrayList<MenuItem> items;
	int position = 0; 

	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public boolean hasNext() {
		if(position >= items.size() || items.get(position) == null){
			return false;
		}
		return true;
	}

	public Object next() {
		MenuItem menuItem = (MenuItem) items.get(position);
		position++;
		return menuItem;
	}

}
