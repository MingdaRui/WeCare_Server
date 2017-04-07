package com.wecare.entry;


public class Food{
	private int _id;
	private String kind;
	private String categray;
	private double g;
	private double calorie;
	private String userId;

	
	
	public Food(String kind, String categray, double g, double calorie) {
		super();
		this.kind = kind;
		this.categray = categray;
		this.g = g;
		this.calorie = calorie;
	}

	public Food(String kind, String categray,double g, double calorie, String userId) {
		super();
		this.kind = kind;
		this.categray = categray;
		this.g = g;
		this.calorie = calorie;
		this.userId = userId;
	}

	public Food(int _id, String kind, String categray, double g, double calorie, String userId) {
		super();
		this._id = _id;
		this.kind = kind;
		this.categray = categray;
		this.g = g;
		this.calorie = calorie;
		this.userId = userId;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCategray() {
		return categray;
	}

	public void setCategray(String categray) {
		this.categray = categray;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Food [_id=" + _id + ", kind=" + kind + ", categray=" + categray + ", g=" + g + ", calorie=" + calorie
				+ ", userId=" + userId + "]";
	}
	
}
