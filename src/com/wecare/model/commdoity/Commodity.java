package com.wecare.model.commdoity;

public abstract class Commodity {

	String commodityId;
	String commodityName;
	
	public Commodity() {}
	
	public Commodity(String commodityId, String commodityName){
		
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		
	}
	
	public abstract void init();
}
