
public class Euclids {
	
	public static int gcd( int p, int q){
		if(q == 0) return p; 
		int r = p % q;
		return gcd( q, r); 
	}
	public static void main(String[] args){
		int c = gcd(10, 3);
		int a = gcd(138, 34); 
		System.out.println(c);
		System.out.println(a);
	}

}
