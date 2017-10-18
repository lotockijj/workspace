package designpatterns.facade;

import java.sql.Date;
import java.util.Calendar;

public class Header {
	private String head;
	private Date date;

	public Header(String head, Date date) {
		this.head = head;
		this.date = date;
	}
	
	public boolean isValid(){
		if(head.length() < 250 && date.before(Calendar.getInstance().getTime())){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean save(){
		if(isValid()){
			System.out.println(head + " :: " + date);
			return true;
		} else {
			return false;
		}
	}

	public String getHead() {
		return head;
	}

	public Date getDate() {
		return date;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
