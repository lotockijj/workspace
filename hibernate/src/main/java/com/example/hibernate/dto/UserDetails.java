package com.example.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//when you mark your field as transient and static hibernate doesn't include them in db.
@Entity /*(name="USER_DETAILS")*/
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
//	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
//	@Column(name="USER_NAME")
	//@Transient
	private String userName;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE_NAME"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	//@Lob
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
