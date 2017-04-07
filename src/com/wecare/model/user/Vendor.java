package com.wecare.model.user;

public class Vendor extends Users {

	int product_id;
	String product_name;
	String product_price;
	String product_description;
	
	public Vendor(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public Vendor(String username, String password, int product_id, String product_name, String product_price, String product_description) {
		super(username, password, "vendor");
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_description = product_description;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public String getProduct_price() {
		return product_price;
	}
	
	public String getProduct_description() {
		return product_description;
	}
	
}
