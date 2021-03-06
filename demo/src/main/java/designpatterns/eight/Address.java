package designpatterns.eight;

class Address implements Cloneable{
	public String country;
	public String city;
	public String street;

	public Address(String country, String city, String street) {
		this.country = country;
		this.city = city;
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + "]";
	}  
	
}