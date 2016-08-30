package iterator;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator  {

	ArrayList items;
	int position = 0; 

	public PancakeHouseMenuIterator(ArrayList items) {
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
