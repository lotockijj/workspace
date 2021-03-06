package designpatterns.eight;

public final class Company {
	private final String name;
	private final Address address;
	private final int phoneNumber;
	private final int fax;

	public Company(String name, Address address, int phoneNumber, int fax) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public int getFax() {
		return fax;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", fax=" + fax + "]";
	}

	
}
