package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution3 {
		public static void main(String[] args) throws Exception {
	     BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	    String s1 = reader.readLine();
	    String s2 = reader.readLine();
	    int a = s1.length();
	    int b = s2.length();
	    if(s1.equals(s2))
	    System.out.print("Имена идентичны");
	    else 
	    {if(a==b)
	    System.out.print("Длины имен равны");
	    }
	}
}           