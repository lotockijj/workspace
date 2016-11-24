package main.java.faberlic;

import java.sql.Date;

public class Faberlic {
	
	int id;
	String name;
	int article;
	int amount;
	Date date_production;
	Date expiration_date;
	Date end_date;
	
	public Faberlic(int id, String name, int article, int amount, Date date_production, Date expiration_date,
			Date end_date) {
		super();
		this.id = id;
		this.name = name;
		this.article = article;
		this.amount = amount;
		this.date_production = date_production;
		this.expiration_date = expiration_date;
		this.end_date = end_date;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getArticle() {
		return article;
	}
	public int getAmount() {
		return amount;
	}
	public Date getDate_production() {
		return date_production;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setArticle(int article) {
		this.article = article;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public void setDate_production(Date date_production) {
		this.date_production = date_production;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return id + ". name=" + name + ", article=" + article + ", amount=" + amount
				+ ", production=" + date_production + ", expiration=" + expiration_date + ", end date="
				+ end_date;
	}

}
