package gui;

public class User {
	int id;
	String last_name;
	String first_name;
	String email;
	String password;
	
	public User(){
	}
	
	public User(int id, String last_name, String first_name, String email, String password) {
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ ", password=" + password + "]";
	}
}
