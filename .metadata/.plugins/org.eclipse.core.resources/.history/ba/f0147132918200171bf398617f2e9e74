package eleks.sportclub;

import java.sql.Date;

import decorator.Price;

public class Client{
	private int id;
	private String lastName;
	private String firstName;
	private int age;
	private Date birthDate;
	private String city;
	private Gender gender;
	private boolean bodyBuildingWinner; // once in month priceless service
	private Date startDate; //5%
	
	private Price price;

	public Client() {
	}
	
	public Client(String lastName, String firstName, int age, Date birthDate, 
			String cityName, Gender gender, boolean bodyBuildingWinner) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.birthDate = birthDate;
		this.city = cityName;
		this.gender = gender;
		this.bodyBuildingWinner = bodyBuildingWinner;
	}

	
	public Client(String lastName, String firstName, int age, Date birthDate, String city, 
			Gender gender, boolean bodyBuildingWinner, Date startDate) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.birthDate = birthDate;
		this.city = city;
		this.gender = gender;
		this.bodyBuildingWinner = bodyBuildingWinner;
		this.startDate = startDate;
	}

	public Client(int id, String lastName, String firstName, int age, Date birthDate, String city, Gender gender,
			boolean bodyBuildingWinner, Date startDate, Price price) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.birthDate = birthDate;
		this.city = city;
		this.gender = gender;
		this.bodyBuildingWinner = bodyBuildingWinner;
		this.startDate = startDate;
		this.price = price;
	}

	public int getId(){
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getAge() {
		return age;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getCity() {
		return city;
	}
	public Gender getGender() {
		return gender;
	}
	public Date getStartDate(){
		return startDate;
	}
	public boolean getBodybuildingWinner(){
		return bodyBuildingWinner;
	}
	public Price getPrice(){
		return price;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setCity(String cityName) {
		this.city = cityName;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setBodybuildingWinner(boolean bodyBuildingWinner){
		this.bodyBuildingWinner = bodyBuildingWinner;
	}
	
	public void setPrice(Price price){
		price.setPrice(startDate);
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Client [lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", birthDate=" + birthDate
				+ ", cityName=" + city + ", gender=" + gender + ", bodyBuildingWinner=" + bodyBuildingWinner
				+ ", startDate=" + startDate + "]";
	}


}
