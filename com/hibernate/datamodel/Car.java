package com.hibernate.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car")

public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="car_id")
	private long car_id;
	
	public Car() {
		super();
	}

	public Car(long car_id, String reg_no, String model, String color, String manufacturer, Owner owner) {
		super();
		this.car_id = car_id;
		this.reg_no = reg_no;
		this.model = model;
		this.color = color;
		this.manufacturer = manufacturer;
		this.owner = owner;
	}

	@Column(name="reg_no")
	private String reg_no;
	
	@Column(name="model")
	private String model;
	
	@Column(name="color")
	private String color;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="owner_id", nullable=false)
	private Owner owner;

	public long getCar_id() {
		return car_id;
	}

	public void setCar_id(long car_id) {
		this.car_id = car_id;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public String toString()
	{
		return "car id : "+this.car_id+"model : "+this.model+" color : "+this.color+" Manufacturer : "+this.manufacturer;
		
	}

}
