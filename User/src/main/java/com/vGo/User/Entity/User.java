package com.vGo.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
	private String userId;
	private String password;
	private String name;
	private String city;
	private Long   phoneNo;
	private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User() {
		
	}
	public User(String userId, String password, String name, String city, Long phoneNo, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.city = city;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", city=" + city
				+ ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	

}
