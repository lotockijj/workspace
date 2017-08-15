package eleks.sportclub.helpful;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionInterfaceTry {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Print all numbers");
		print(list, n -> true);
		print(list, n -> n%2 == 0);
		print(list, n -> n > 5);
		print(list, n -> n%3 == 0);
		print(list, n -> n == 5);
	}
	
	public static void print(List<Integer> list, Predicate<Integer> predicate){
		for(Integer n : list){
			if(predicate.test(n)){
				System.out.print(n + ", ");
			}
		}
		System.out.println();
	}
}
