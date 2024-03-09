package com.vGo.User.DTO;

import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotNull(message="IDi Kavali ra Babu..")
	private String userId;
    @NotNull(message="IDi Kavali ra Babu..")
	private String password;
    @NotNull(message="IDi Kavali ra Babu..")
	private String name;
    @NotNull(message="IDi Kavali ra Babu..")
	private String city;
    @NotNull(message="IDi Kavali ra Babu..")
	private Long   phoneNo;
    @NotNull(message="IDi Kavali ra Babu..")
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
}
