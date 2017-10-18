package Week2;
/*
Give the array that results after the first 6 exchanges (not iterations!)
when insertion sorting the following array:

    19 23 31 55 87 40 17 89 11 72 
Your answer should be a sequence of 10 integers, separated by whitespace.
 */
@SuppressWarnings("rawtypes")
public class Insertion {

	private static int count;
	public static void sort( Comparable[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			for(int j = i; j > 0; j--){
				if(less(a[j], a[j-1])){
					exch(a, j, j - 1);
					count++; 
				} else{
					break; 
				}
			} 
		}
	}

	private static void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap; 
		if(count == 5){
			for (int i1 = 0; i1 < a.length; i1++) {
				System.out.print(a[i1] + " ");
			}
			System.out.println();
			System.out.print(" count = " + count + "\n");
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	public static void main(String[] args){
		Comparable[] a = {19, 23, 31, 55, 87, 40, 17, 89, 11, 72};
		Insertion.sort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
