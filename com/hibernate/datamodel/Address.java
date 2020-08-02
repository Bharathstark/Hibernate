package com.hibernate.datamodel;

public class Address {
	   public Address(String doorNo, String city, String state, String pincode) {
		super();
		this.doorNo = doorNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	private int id;
	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address() {
		super();
	}
	public Address(int id, String doorNo, String city, String state, String pincode) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	private String doorNo;     
	   private String city;     
	   private String state;    
	   private String pincode; 
}
