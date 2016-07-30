package yakov.fain;

public class TestTax {

	public static void main(String[] args) {
		//Tax t = new Tax();
		//AdjustForStudents t = new AdjustForStudents();
		long start = System.currentTimeMillis (); // in order to find full time working method. 
		
		AdjustForStudents t = new AdjustForStudents(40000, "NJ", 2);
		Tax t2 = new Tax(65000, "TX", 4 );
		
		//t.crossIncome = 40000;
		//t.dependents = 2;
		//t.state = "NJ";
		
		double hisTax = t2.calcTax();
		
		double yourTax = t.calcTax();
		double totalTax = t.adjustForStudents(yourTax);
		System.out.println("Your tax is " + yourTax);
		System.out.println("Your total tax is " + totalTax);
		System.out.println("Your total tax in euro is " + Tax.convertToEuros(totalTax) + " euros.");
		
		System.out.println("Your total tax is " + hisTax);
		System.out.println("Your total tax in euro is " + Tax.convertToEuros(hisTax) + " euros.");
		
		long end = System.currentTimeMillis ();
		System.out.println ( "Час, витрачений на виконання " + ( end - start )) ;
	}

}
