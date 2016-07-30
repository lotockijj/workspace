
public class Amount {

	public static void main(String[] args) {
		int i = 1; 
		int j = 0; 
		String m = "";
		System.out.println(1);
		while (i<10){
			m = m + String.valueOf(i) + "+"; 
			i++;
			j = j + i; 
			System.out.println(m + i + "=" + (j + 1)); 
		}
		
		String m1 = System.getProperty("user.dir");
        System.out.println(m1);
	}

}
