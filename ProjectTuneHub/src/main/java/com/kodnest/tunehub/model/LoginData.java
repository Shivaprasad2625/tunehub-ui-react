package com.kodnest.tunehub.model;

public class LoginData {
	public String email;
	public String password;
	
	@Override
	public String toString() {
		return "LoginData [email=" + email + ", password=" + password + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginData() {
		super();
	}
	public LoginData(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
}
