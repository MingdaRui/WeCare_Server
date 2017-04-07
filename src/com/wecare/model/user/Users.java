package com.wecare.model.user;

public class Users {

	private String userName;
	private String password;
	private String userType;
	
	public Users() {}
	
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Users(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserName(String un) {
		userName = un;
	}
	
	public void setPassword(String pw) {
		password = pw;
	}

	public void setUserType(String ut) {
		userType = ut;
	}
}
