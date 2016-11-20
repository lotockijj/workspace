// Create method which prints sum of digits number... 

public class SumaDigit {

	public static int sumOfDigits(int n) {
	    String digits = new Integer(n).toString();
	    int sum = 0;
	    for (char c: digits.toCharArray())
	        sum += c - '0';
	    return sum;
	}
	
	public static void main(String[] args) {
		int number = 11125;
		int result = 0;
		int result2 = 0; 
		String s = Integer.toString(number);
		String s1 = String.valueOf(number);
		for(int i = 0; i < s.length(); i++){
			result += Character.getNumericValue(s.charAt(i));
			
		}
		for(int i = 0; i < s1.length(); i++){
			result2 += Character.getNumericValue(s1.charAt(i));
			
		}
		System.out.println(result);
		System.out.println(result2);
		System.out.println(SumaDigit.sumOfDigits(number) + "\n");
		
		int a; 
        int b = 0;
        int c = 1;
        int sum = 0;

        for (int i = 0; i < 10; i++) { // Finds fibonacci sequence
            a = b;
            b = c;
            c = a + b;

            if (c % 2 == 0)  // Check if it's even
                sum += c;
        }
        System.out.println(sum);
	}

}