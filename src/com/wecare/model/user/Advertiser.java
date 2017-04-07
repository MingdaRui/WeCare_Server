package com.wecare.model.user;

public class Advertiser extends Users {

	int ad_id;
	String ad_title;
	String ad_description;
	
	public Advertiser(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public Advertiser(String username, String password, int ad_id, String ad_title, String ad_description) {
		super(username, password, "advertiser");
		this.ad_id = ad_id;
		this.ad_title = ad_title;
		this.ad_description = ad_description;
	}
	
	public int getAd_id() {
		return ad_id;
	}
	
	public String getAd_title() {
		return ad_title;
	}
	
	public String getAd_description() {
		return ad_description;
	}

}
