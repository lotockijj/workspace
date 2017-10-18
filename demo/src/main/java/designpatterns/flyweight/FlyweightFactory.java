package designpatterns.flyweight;

import java.util.HashMap;

public class FlyweightFactory {
	private HashMap<String, FlyweightIntr> lstFlyweight;
	private static FlyweightFactory factory = new FlyweightFactory();
	
	private FlyweightFactory(){
		lstFlyweight = new HashMap<>();
	}
	
	public synchronized FlyweightIntr getFlyweightIntr(String divisionName){
		if(lstFlyweight.get(divisionName) == null){
			FlyweightIntr fw = new Flyweight(divisionName);
			lstFlyweight.put(divisionName, fw);
			return fw;
		} else {
			return lstFlyweight.get(divisionName);
		}
	}
	
	public static FlyweightFactory getInstance(){
		return factory;
	}
	
	public class Flyweight implements FlyweightIntr{
		private String medicalInsurance;
		private String dentalInsurance;
		private String visionCare;
		private String tax401;
		private int numberOfHoursOfWork;
		private boolean paidVacation;
		private String employerName;
		private String employerAddress;
		
		private void setValues(String med, String den, String vis, String tax, int num, 
				boolean paidV, String name, String addr){
			medicalInsurance = med;
			dentalInsurance = den;
			visionCare = vis;
			tax401 = tax;
			numberOfHoursOfWork = num;
			paidVacation = paidV;
			employerName = name;
			employerAddress = addr;
		}
		
		public Flyweight(String divisionName) {
			// values are hardcoded for simplicity
			if(divisionName.equals("eleks")){
				setValues("med5", "den5", "vis5", "tax3", 11, true, "eleks", "Lviv, Naukova7B");
			}
			if(divisionName.equals("ibm")){
				setValues("med3", "den3", "vis3", "tax5", 1, false, "IBM", "New York, 115 Avenue");
			}
		}
		
		@Override
		public String getMedicalInsurance() {
			return medicalInsurance;
		}

		@Override
		public String getDentalInsurance() {
			return dentalInsurance;
		}

		@Override
		public String getVisionCare() {
			return  visionCare;
		}

		@Override
		public String get401() {
			return tax401;
		}

		@Override
		public int getNumberOfHoursOfWork() {
			return numberOfHoursOfWork;
		}

		@Override
		public boolean isPaidVacation() {
			return paidVacation;
		}

		@Override
		public String getEmployerName() {
			return employerName;
		}

		@Override
		public String getEmployerAddress() {
			return employerAddress;
		}

		@Override
		public void print(String title, String experience) {
			System.out.println(title + ", " + experience + ", " + medicalInsurance + ", " +
		 dentalInsurance + ", " + visionCare + ", " + tax401 + ", " + numberOfHoursOfWork + 
		 ", " + paidVacation + ", " + employerName + ", " + employerAddress);
			
		}
		
	}
}
