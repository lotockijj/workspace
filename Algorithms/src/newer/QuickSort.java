package newer;

/**Quicksort or partition-exchange sort, is a fast sorting algorithm, 
 * which is using divide and conquer algorithm. Quicksort first divides a large list
 * into two smaller sub-lists: the low elements and the high elements.
 * Quicksort can then recursively sort the sub-lists.
 * Steps to implement Quick sort:
 * 1) Choose an element, called pivot, from the list. 
 * Generally pivot can be the middle index element.
 * 2) Reorder the list so that all elements with values less than the pivot come 
 * before the pivot, while all elements with values greater than the pivot come after it
 * (equal values can go either way). After this partitioning, the pivot is in its final
 * position. This is called the partition operation.
 * 3) Recursively apply the above steps to the sub-list of elements with smaller values and 
 * separately the sub-list of elements with greater values.
*/

public class QuickSort {
	
	public static void sort(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		quickSort(arr, low, high);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}
