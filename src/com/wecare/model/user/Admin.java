package com.wecare.model.user;

public class Admin extends Users{
	
	public Admin(String username, String password){
		super(username, password);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return super.getUserType();
	}

	@Override
	public void setUserName(String un) {
		// TODO Auto-generated method stub
		super.setUserName(un);
	}

	@Override
	public void setPassword(String pw) {
		// TODO Auto-generated method stub
		super.setPassword(pw);
	}

	@Override
	public void setUserType(String ut) {
		// TODO Auto-generated method stub
		super.setUserType(ut);
	}
	
	
}
