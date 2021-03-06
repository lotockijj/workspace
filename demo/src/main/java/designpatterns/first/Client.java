package designpatterns.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Client {
	
	public static void main(String[] args) throws IOException {
		int[] arr = {2, 4, 5, 1, 3, 8, 100, 25, 26, 29, 41, 11, 21};
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int key = Integer.parseInt(reader.readLine());
		reader.close();
		
		Search search = new LinearSearch();
		System.out.println(search.getItem(arr, key));
		
		search = new BinarySearch();
		Arrays.sort(arr);
		System.out.println(search.getItem(arr, key));
	} 

}
