package com.hibernate.project;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.datamodel.Employee;
public class EmployeeMain {
	public static void main(String args[])
	{
		Employee emp=new Employee(0, "krishna", "kumar", 200);
		EmployeeDao.add(emp);
		emp=new Employee(0, "blisston", "kumar", 200);
		EmployeeDao.add(emp);
	System.out.println(EmployeeDao.edit(emp));
		
	}

}
