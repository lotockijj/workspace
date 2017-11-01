package softserve.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	// my solution was much worse (without !Character.toString(s.charAt(i)).equals(" ") )... 
	// and contained many small mistake... 
	public static String computeMySolution(String s){
		StringBuilder strB = new StringBuilder();
		int index = 1;
		for (int i = 0; i < s.length(); i++) {
			if(!Character.toString(s.charAt(i)).equals(" ")){
				for (int j = 0; j < s.length(); j++) {
					if(i != j){
						if(s.charAt(i) == s.charAt(j)){
							index++;
						}
					}
				}
				if(!(strB.indexOf(Character.toString(s.charAt(i))) != -1)){
					strB.append(s.charAt(i)).append("=").append(index).append("\n");
				}
				index = 1;
			}
		}
		return strB.toString();
	}

	public static String compute(String s){
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if(!Character.toString(s.charAt(i)).equals(" ")){
				if(map.containsKey(s.charAt(i))){
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
				} else {
					map.put(s.charAt(i), 1);
				}
			}
		}
		return map.toString();
	}

	public static String computeWithLambda(String s){
		Map<Character, Long> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(!(Character.toString(s.charAt(i)).equals(" "))){
				final char ch = s.charAt(i);
				long index = IntStream.range(0, s.length())
						.filter(p->s.charAt(p) == ch)
						.count();
				map.put(ch, index);
			}
		}
		return map.toString();
	}
	
	public static String computeWithLambdaTwo(String s){
		 Map<Character, Long> map = IntStream.range(0, s.length())
				 .filter(p -> s.charAt(p) != ' ')
	             .mapToObj(i-> s.charAt(i))
	             .collect(Collectors.groupingBy(o->o, Collectors.counting()));      

//	     map.keySet().stream()
//	        .forEach(key -> System.out.println("'" + key + "'->" + map.get(key)));
		return map.toString();
	}

	public static void main(String[] args) {
		String input = "Hello Hello Roman";
		System.out.println(Solution.computeMySolution(input));
		System.out.println(Solution.compute(input));
		System.out.println("LAMBDA AS NINZIA :) :) :) ");
		System.out.println(Solution.computeWithLambda(input));
		System.out.println(Solution.computeWithLambdaTwo(input));
	}
}
