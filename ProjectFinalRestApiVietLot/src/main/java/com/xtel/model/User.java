package com.xtel.model;


public class User {
	private String identify;
	private String vietlot_number;
	private int cost;
	public User(String identify, String vietlot_number, int cost) {
		super();
		this.identify = identify;
		this.vietlot_number = vietlot_number;
		this.cost = cost;
	}
	public String getIdentify() {
		return identify;
	}
	public String getVietlot_number() {
		return vietlot_number;
	}
	public int getCost() {
		return cost;
	}
	
	
}
