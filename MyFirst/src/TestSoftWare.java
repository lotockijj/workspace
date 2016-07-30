import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSoftWare {
	public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String s = reader.readLine();
	
	char [] a = s.toCharArray ();
	int d [] = new int [a.length];
	for( int i = 0; i < a.length ; i++){
		d[i] = Character.getNumericValue(a[i]);
		//d[i] = String.valueOf(a[i]);
	}
	int [] c = new int[a.length];
	for (int i = 0; i < a.length; i++){
		//c[i] = Integer.parseInt(d[i]);
		
	}
	int m = 0; 
		for(int i = 0; i<c.length; i++){
			m = m + d[i]; 
		}
		System.out.printf("Сума цифр цього числа = %s", m);
	}
}
