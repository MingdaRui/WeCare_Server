package com.wecare.model.user;

import java.util.Date;


public class Customer{
	private int id;
	private String username;
	private String password;
	private String email;  
	private String userGoal;
	private String gender;
	private Date dayOfBirth;
	private String country;
	private double height;
	private double weight;
	private double goalOfWeight;
	private double weeklyGoal;
	
	public Customer() {}
	
	public Customer(int id, String username, String password, String email, String userGoal, String gender, Date dayOfBirth,
			String country, double height, double weight, double goalOfWeight, double weeklyGoal) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userGoal = userGoal;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.country = country;
		this.height = height;
		this.weight = weight;
		this.goalOfWeight = goalOfWeight;
		this.weeklyGoal = weeklyGoal;
	}


	public Customer(String username, String password, String email, String userGoal, String gender, Date dayOfBirth,
			String country, double height, double weight, double goalOfWeight, double weeklyGoal) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.userGoal = userGoal;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.country = country;
		this.height = height;
		this.weight = weight;
		this.goalOfWeight = goalOfWeight;
		this.weeklyGoal = weeklyGoal;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserGoal() {
		return userGoal;
	}
	public void setUserGoal(String userGoal) {
		this.userGoal = userGoal;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getGoalOfWeight() {
		return goalOfWeight;
	}
	public void setGoalOfWeight(double goalOfWeight) {
		this.goalOfWeight = goalOfWeight;
	}
	public double getWeeklyGoal() {
		return weeklyGoal;
	}
	public void setWeeklyGoal(double weeklyGoal) {
		this.weeklyGoal = weeklyGoal;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", userGoal=" + userGoal
				+ ", gender=" + gender + ", dayOfBirth=" + dayOfBirth + ", country=" + country + ", height=" + height
				+ ", weight=" + weight + ", goalOfWeight=" + goalOfWeight + ", weeklyGoal=" + weeklyGoal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dayOfBirth == null) ? 0 : dayOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(goalOfWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userGoal == null) ? 0 : userGoal.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		temp = Double.doubleToLongBits(weeklyGoal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	
}
