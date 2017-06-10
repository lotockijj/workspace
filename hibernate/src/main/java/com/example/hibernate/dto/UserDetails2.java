package com.example.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS2")
public class UserDetails2 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_TABLE",
			   joinColumns = @JoinColumn(name="USER_ID")
	)
//	@GenericGenerator(name="hilo-gen", strategy="hilo")
//	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type = @Type(type="long"))
	private Collection<Address2> listOfAddresses = new ArrayList<Address2>();
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Address2> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address2> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}
