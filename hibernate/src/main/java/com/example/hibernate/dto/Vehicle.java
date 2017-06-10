package com.example.hibernate.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)//.TABLE_PER_CLASS //.SINGLE_TABLE
//@DiscriminatorColumn(
//		name="VEHICLE_TYPE",
//		discriminatorType=DiscriminatorType.STRING
//		)
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	//		@ManyToOne
	//		@JoinColumn(name="USER_ID")
//	@ManyToMany(mappedBy="vehicle")
//	private Collection<UserDetails3> userList = new ArrayList<UserDetails3>();

	//	@ManyToOne
	//	@NotFound(action=NotFoundAction.IGNORE)
	//	private UserDetails3 userDetails;

	//	public UserDetails3 getUserDetails() {
	//		return userDetails;
	//	}
	//	public void setUserDetails(UserDetails3 userDetails) {
	//		this.userDetails = userDetails;
	//	}
//	public Collection<UserDetails3> getUserList() {
//		return userList;
//	}
//	public void setUserList(Collection<UserDetails3> userList) {
//		this.userList = userList;
//	}
	public int getVehicleId() {
		return vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
