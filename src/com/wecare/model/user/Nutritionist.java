package com.wecare.model.user;

public class Nutritionist extends Users {

	int dietary_id;
	String dietary_title;
	String dietary_type;
	String dietary_content;
	
	public Nutritionist(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public Nutritionist(String username, String password, int dietary_id, String dietary_title, String dietary_type, String dietary_content) {
		
		super(username, password, "nutritionist");
		this.dietary_id = dietary_id;
		this.dietary_title = dietary_title;
		this.dietary_type = dietary_type;
		this.dietary_content = dietary_content;
		
	}

	public int getDietary_id() {
		return dietary_id;
	}
	
	public String getDietary_type() {
		return dietary_type;
	}
	
	public String getDietary_title() {
		return dietary_title;
	}
	
	public String getDietary_content() {
		return dietary_content;
	}
	
}
