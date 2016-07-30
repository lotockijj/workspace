package week3QuickSort;

public class QuicSort {
	
	private static int portition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi + 1;
		while(true){
			while(less(a[++i], a[lo])){ //find item on left to swap
				if(i == hi) break;
			}
			while(less(a[lo], a[--j])){ //find item on right to swap
				if(j == lo) break;
			}
			if(i >= j) break; //check if pointers cross swap
			exch(a, i, j); 
			return j; 
		}
		exch(a, lo, j); //swap with portitioning item
		return j; //return index of item now known to be in place
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap; 
	}
}
