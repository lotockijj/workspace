package newer;

/**Bubble sort, also referred to as sinking sort, is a simple sorting algorithm that 
 * works by repeatedly stepping through the list to be sorted, comparing each pair 
 * of adjacent items and swapping them if they are in the wrong order. 
 * The pass through the list is repeated until no swaps are needed, which indicates 
 * that the list is sorted. The algorithm gets its name from the way smaller 
 * elements "bubble" to the top of the list. Because it only uses comparisons to operate 
 * on elements, it is a comparison sort. Although the algorithm is simple, 
 * most of the other sorting algorithms are more efficient for large lists.
 */

public class BubbleSort {
	
	public static void sort(int[] arr){
		for(int i = arr.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[i]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}
