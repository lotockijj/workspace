import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String s = reader.readLine();
    	int m = Integer.parseInt(s);
    	long k = 1;
    	for(int i = 1; i < m + 1; i++){
    		k =  k * i; 
    	}
    	System.out.println(k);
	}
}
