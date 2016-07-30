package yakov.fain;

public class AdjustForStudents extends Tax{

	AdjustForStudents(double cr, String st, int dep) {
		super(cr, st, dep);
	}

	double adjustForStudents(double Tax){
		double adjastedTax = Tax - 500;
		return adjastedTax;
	}
	
	public double calcTax(){

		if(crossIncome <= 50000){
			return crossIncome*0.1;
		}

		else{
			return crossIncome*0.13;
		}
	}

}
