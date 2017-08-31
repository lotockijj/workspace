package designpatterns.ten;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LogMessage {
	@Id
	int id;
	String msg;

	public LogMessage(String msg) {
		this.msg = msg;
	}
}
