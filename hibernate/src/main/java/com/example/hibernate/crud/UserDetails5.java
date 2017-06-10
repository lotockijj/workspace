package com.example.hibernate.crud;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="UserDetails5.byId", query="from UserDetails5 where id = ? ")
@NamedNativeQuery(name="UserDetails5.byName", query="select *from userdetails5 where userName = ?",
					resultClass=UserDetails5.class)
//@org.hibernate.annotations.Entity(dynamicUpdate=true) - deprecated
//@DynamicUpdate
@SelectBeforeUpdate
public class UserDetails5{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
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
	
}
