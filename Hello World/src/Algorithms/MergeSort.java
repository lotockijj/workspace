package Algorithms;

public class MergeSort {
	
	int[] less;
	int[] more;
	int middle;
	
	public void recursive(int a[]){
		middle = a.length/2;
	}
	
	private boolean less(int b, int c){
		return b < c; 
	}
	
	
	private void excange(int a[], int b, int c){
		if(c > b){
			int j = a[b];
			a[b] = a[c];
			a[c] = j; 
		}
	}

}
