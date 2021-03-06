package lambda;

import java.time.LocalDate;

public class Person {
	public enum Sex{ MALE, FEMALE}
	private String name;
	private LocalDate birthDay;
	private Sex gender;
	private String email;

	public Person(String name, LocalDate birthDate, Sex gender, String email) {
		this.name = name;
		this.birthDay = birthDate;
		this.gender = gender;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDay;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDay = birthDate;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge(){
		return LocalDate.now().getYear() - birthDay.getYear();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthDay=" + birthDay + ", gender=" + gender + ", email=" + email + "]";
	}
	
	
}
