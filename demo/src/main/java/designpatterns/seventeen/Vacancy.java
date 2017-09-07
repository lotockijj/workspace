package designpatterns.seventeen;

public class Vacancy {
	private String title;
	private int expereince;
	private FlyweightIntr flyweight;

	public Vacancy(String title, int expereince, FlyweightIntr flyweight) {
		this.title = title;
		this.expereince = expereince;
		this.flyweight = flyweight;
	}

	public String getTitle() {
		return title;
	}

	public int getExpereince() {
		return expereince;
	}

	public FlyweightIntr getFlyweight() {
		return flyweight;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setExpereince(int expereince) {
		this.expereince = expereince;
	}

	public void setFlyweight(FlyweightIntr flyweight) {
		this.flyweight = flyweight;
	}

	@Override
	public String toString() {
		return title + ", expereince: " + expereince + "\t" + flyweight.getMedicalInsurance() + ", " +
				flyweight.getDentalInsurance() + ", " +     flyweight.getVisionCare() + ", " +
				flyweight.get401() + ", " +                 flyweight.getVisionCare() + ", " + 
				flyweight.getNumberOfHoursOfWork() + ", " + flyweight.getEmployerName() + " ," + 
				flyweight.getEmployerAddress() + ".";
	}

  

}
