package jspproject;

//dto - data transfer object
public class User {
	private String userName;
	private String userId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String pincode;
	public String getUserName() {
		return userName;
	}
	public String getUserId() {
		return userId;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}