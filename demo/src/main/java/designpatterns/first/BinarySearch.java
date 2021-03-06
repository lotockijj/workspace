package designpatterns.first;

public class BinarySearch implements Search {

	@Override
	public int getItem(int[] arr, int item) {
		int high = arr.length - 1;
		int low = 0;
		while(high >= low){
			System.out.print("+ ");
			int mid = low + (high - low)/2;
			if(item < arr[mid]) high = mid - 1;
			else if(item > arr[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
	}

}
