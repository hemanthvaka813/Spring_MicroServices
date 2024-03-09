package com.vGo.User.DTO;

import jakarta.validation.constraints.NotEmpty;

public class LoginDTO {
	@NotEmpty(message="idi lekunda login avvalevu babu..")
	private String userId;
	@NotEmpty(message="idi lekunda login avvalevu babu..")
	private String password;
	
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
	
	
}
