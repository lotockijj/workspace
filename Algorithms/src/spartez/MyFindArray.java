package spartez;

/**Find the last Array
* Question
* Implement a method that given two arrays as parameters will find the starting index where the second parameter occurs as a sub-array in the array given as the first parameter.
* If given sub-array (second parameter) occurs more than once, then the method should return the starting index of the last occurrence
* Your implementations should return -1 if the sub-array cannot be found.
* Your implementation must implement the FindArray interface.
* For extra points: implement it in an efficient way for large input arrays.
* Sample Input:
* [4,9,3,7,8] and [3,7] should return 2.
* [1,3,5] and [1] should return 0.
* [7,8,9] and [8,9,10] should return -1.
* [4,9,3,7,8,3,7,1] and [3,7] should return 5.
*/

public class MyFindArray {
	
	public int findArray(int[] array, int[] subArray) {
		int index = -1;
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0, z = i; j < subArray.length; j++) {
				if(array[z] == subArray[j]){ //[7,8,9] and [8,9,10] should return -1.
					flag = true;
				} else {
					flag = false;
				}
				z++;
				if(z >= array.length){
					if(j <= z){
						flag = false;
					}
					break;
				}
			}
			if(flag){
				index = i;
			}
		}
        return index;
    }
}
