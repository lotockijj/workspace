import java.util.Scanner;

public class Suma {
	public static void main(String args[]){
		Scanner input = new Scanner (System.in);
		int a, b;
		int suma;
		System.out.println("¬вед≥ть перше число");
		a=input.nextInt();
		System.out.println("¬вед≥ть друге число");
		b=input.nextInt();
		input.close();
		suma = a + b; 
		System.out.println("Cума р≥вна" + suma);
	}

}

