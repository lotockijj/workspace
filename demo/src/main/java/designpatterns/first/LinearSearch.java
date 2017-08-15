package designpatterns.first;

public class LinearSearch implements Search {

	@Override
	public int getItem(int[] arr, int item) {
		for(int i = 0; i < arr.length; i++){
			System.out.print("+ ");
			if(arr[i] == item){
				return i;
			}
		}
		return -1;
	}

}
