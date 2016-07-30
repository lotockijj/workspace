import java.util.Calendar;
import java.util.Locale;

class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		int i = 461012;
		System.out.format("The value of i is: %d%n", i);
		Object floatVar = null;
		Object intVar = 2;
		Object stringVar = null;
		System.out.format(Locale.FRANCE,
			    "The value of the float " + "variable is %f, while the " +
			    "value of the integer variable " + "is %d, and the string is %s%n", 
			    floatVar, intVar, stringVar); 
		 long n = 461012;
	      System.out.format("%d%n", n);      //  -->  "461012"
	      System.out.format("%08d%n", n);    //  -->  "00461012"
	      System.out.format("%+8d%n", n);    //  -->  " +461012"
	      System.out.format("%,8d%n", n);    // -->  " 461,012"
	      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
	      
	      double pi = Math.PI;

	      System.out.format("%f%n", pi);       // -->  "3.141593"
	      System.out.format("%.3f%n", pi);     // -->  "3.142"
	      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
	      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
	      System.out.format(Locale.FRANCE,
	                        "%-10.4f%n%n", pi); // -->  "3,1416"

	      Calendar c = Calendar.getInstance();
	      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

	      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

	      System.out.format("%tD%n", c);    // -->  "05/29/06"
	      byte largestByte = Byte.MAX_VALUE;
	        short largestShort = Short.MAX_VALUE;
	        int largestInteger = Integer.MAX_VALUE;
	        long largestLong = Long.MAX_VALUE;
	 
	        //real numbers
	        float largestFloat = Float.MAX_VALUE;
	        double largestDouble = Double.MAX_VALUE;
	 
	        //other primitive types
	        char aChar = 'S';
	        boolean aBoolean = true;
	 
	        //Display them all.
	        System.out.println("The largest byte value is "
	                           + largestByte + ".");
	        System.out.println("The largest short value is "
	                           + largestShort + ".");
	        System.out.println("The largest integer value is "
	                           + largestInteger + ".");
	        System.out.println("The largest long value is "
	                           + largestLong + ".");
	 
	        System.out.println("The largest float value is "
	                           + largestFloat + ".");
	        System.out.println("The largest double value is "
	                           + largestDouble + ".");
	 
	        if (Character.isUpperCase(aChar)) {
	            System.out.println("The character " + aChar
	                               + " is uppercase.");
	        } else {
	            System.out.println("The character " + aChar
	                               + " is lowercase.");
	        }
	        System.out.println("The value of aBoolean is "
	                           + aBoolean + ".");
	        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
	        String helloString = new String(helloArray);
	        System.out.println(helloString);
	        String palindrome = "Dot saw I was Tod";
	        int len = palindrome.length();
	        System.out.println("Загальна кількість символів рівна" + " " + len);
	        int aa = (int)3.14;
	        System.out.println(aa);
	        System.out.println(17.11%9);
	        System.out.println(7%3*4);
	        int q = 21, w = 8; 
	        System.out.println("Результат ділення q на w =" + q/w);
	        System.out.println("Залишок ділення q на w =" + q%w);
	        int cc = 68;
	        System.out.println("Сума цифр числа = " + (cc/10+cc%10));
	        double r = 3.99; 
	        int ii = (int) Math.round(r); 
	        System.out.println("Округлене до блищого цілого числа = " + ii);
	        int x = 231, y;
	        y = x%100;
	        System.out.println("Сума цифр трьохзначного числа = " + (x/100+(y/10 + y%10)));
	        String num = "1012";
	        int z = Integer.parseInt(num);
	        System.out.println("Приведення стрічки num до числового значення - " + z);
	}

}
