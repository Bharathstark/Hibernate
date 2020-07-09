package com.hibernate.datamodel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Owner")

public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="owner_id")
	private long owner_id;
	
	@Column(name="owner_name")
	private String owner_name;
	
	public Owner() {
		super();
	}

	public Owner(long owner_id, String owner_name, Set<Car> cars) {
		super();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.cars = cars;
	}

	@OneToMany(mappedBy="owner")
	private Set<Car> cars;

	public long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(long owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
	public void printCars()
	{
		this.cars.forEach((Car car)->{System.out.println(car);});
	}
	@Override
	public String toString()
	{
		return "Owner id is: "+this.owner_id + "this.name : "+ this.owner_name + " No of Cars :"+this.cars.size();
		
	}

}
