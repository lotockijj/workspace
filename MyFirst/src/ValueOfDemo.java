import java.util.Scanner;

public class ValueOfDemo {
	private static Scanner m;

	public static void main(String[] args) {
         m = new Scanner(System.in); 
        // arguments on the command line 
         	int a = m.nextInt(); 
         	int b = m.nextInt();
            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
            
        }
    }


