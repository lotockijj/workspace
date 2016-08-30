package Week3;

public class MergeSort {

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi); 

		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			
				for(int i1 = 0; i1 < a.length; i1++){
					System.out.print(a[i1] + " ");
				}
				System.out.println();
			
			if(i > mid)                   a[k] = aux[j++];
			else if(j > hi)               a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else                          a[k] = aux[i++];

		}
		assert isSorted(a, lo, hi); 
	}

	private static boolean isSorted(Comparable[] a, int lo, int mid) {
		return isSorted(a, lo, mid);
	}

	private static boolean less(Comparable<Comparable> v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(hi <= lo) return; 
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi); 
	}

	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1); 
	}

	public static void main(String[] args){
		Comparable[] a = {45, 90, 28, 30, 16, 20, 70, 22, 43, 67 };
		MergeSort.sort(a);

	}

}
