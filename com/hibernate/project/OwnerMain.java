package com.hibernate.project;

import java.util.HashSet;
import java.util.Set;

import com.hibernate.dao.OwnerDao;
import com.hibernate.datamodel.Car;
import com.hibernate.datamodel.Owner;

public class OwnerMain {

	public static void main(String[] args) {
		Owner  owner =new Owner(0,"Bharath", null);
		Car car=new Car(0,"x","swift", "blue", "ford", owner);
		Car car1=new Car(0,"y","rapid", "red", "scoda", owner);
		Set <Car>set=new HashSet<Car>();
		set.add(car);
		set.add(car1);
		owner.setCars(set);
		System.out.println(owner);
		OwnerDao.add(owner);
		Owner test=OwnerDao.get((long) 4);

	}

}
