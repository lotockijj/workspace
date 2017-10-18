package newer;

/**The selection sort is a combination of searching and sorting. 
 * During each pass, the unsorted element with the smallest (or largest) 
 * value is moved to its proper position in the array. The number of times 
 * the sort passes through the array is one less than the number of items in the array. 
 * In the selection sort, the inner loop finds the next smallest (or largest) value 
 * and the outer loop places that value into its proper location.
 */

public class SelectionSort {
	
	public static void sort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			int index = i;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < arr[index]){
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}
} 
