package iterator2;

import java.util.Iterator;

public class DinerMenuIterator implements iterator2.Iterator, Iterator{

	MenuItem[] items;
	int position;

	public DinerMenuIterator(MenuItem[] items){
		this.items = items;
	}

	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}

	}

	public Object next() {
		MenuItem menuItems = items[position];
		position++;
		return menuItems;
	}

//	public void remove() {
//		if (position <= 0) {
//			throw new IllegalStateException
//			("You can’t remove an item until you’ve done at least one next()Menu");
//		}
//		if (list[position-1] != null) {
//			for (int i = position-1; i < (list.length-1); i++) {
//				list[i] = list[i+1];
//			}
//			list[list.length-1] = null;
//		}
//	}

}
