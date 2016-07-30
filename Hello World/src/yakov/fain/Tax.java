package yakov.fain;

public class Tax {
	
	double crossIncome; 
	String state;
	int dependents;
	int customerCounter;
	
	public Tax(double cr, String st, int dep){
		crossIncome = cr;
		state = st;
		dependents = dep;
		System.out.println("Preparing the tax data for customer # "+ customerCounter);
	}
	
	public double calcTax(){
		
		if(crossIncome <= 50000){
			return crossIncome*0.08;
		}
		
		else{
			return crossIncome*0.06;
		}
	}
	
	public double calcTax1(){
		return crossIncome*0.33 - dependents*100;  //(grossIncome*0.33 – dependents*100);
	}
	
	static double convertToEuros(double totalTax){
		return totalTax/1.25; 
	}

}
