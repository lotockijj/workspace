package softserve2;

public class MySecondTest {
	private String employee;
	private String firstName;
	private String lastName;
	private String address;
	
	public MySecondTest(String employee, String firstName, String lastName, String address) {
		this.employee = employee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public String getEmployee() {
		return employee;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
