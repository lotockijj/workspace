package gui;

import java.sql.Date;

public class UsersHistory {
	int id;
	String last_name;
	String first_name;
	String action;
	Date action_date_time;
	
	public UsersHistory(){
	}
	
	public UsersHistory(int id, String last_name, String first_name, String action, Date action_date_time) {
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.action = action;
		this.action_date_time = action_date_time;
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
	public String getAction() {
		return action;
	}
	public Date getAction_date_time() {
		return action_date_time;
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
	public void setAction(String action) {
		this.action = action;
	}
	public void setAction_date_time(Date action_date_time) {
		this.action_date_time = action_date_time;
	}

	@Override
	public String toString() {
		return "UsersHistory [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", action="
				+ action + ", action_date_time=" + action_date_time + "]";
	}

}
