package newer;

/**Insertion sort is a simple sorting algorithm, it builds the final sorted array 
 * one item at a time. It is much less efficient on large lists than other sort algorithms.
 * Advantages of Insertion Sort: 
 * 1) It is very simple.
 * 2) It is very efficient for small data sets.
 * 3) It is stable; i.e., it does not change the relative order of elements with equal keys.
 * 4) In-place; i.e., only requires a constant amount O(1) of additional memory space.
 * Insertion sort iterates through the list by consuming one input element at each repetition,
 * and growing a sorted output list. On a repetition, insertion sort removes one element 
 * from the input data, finds the location it belongs within the sorted list, and inserts 
 * it there. It repeats until no input elements remain.
*/
public class InsertionSort {

	public static void sort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
}
