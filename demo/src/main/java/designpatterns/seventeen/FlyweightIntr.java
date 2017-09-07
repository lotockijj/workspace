package designpatterns.seventeen;

public interface FlyweightIntr {

	public String getMedicalInsurance();
	public String getDentalInsurance();
	public String getVisionCare();
	public String get401();
	public int getNumberOfHoursOfWork();
	public boolean isPaidVacation();
	public String getEmployerName();
	public String getEmployerAddress();
	public void print(String title, String experience);
	
}