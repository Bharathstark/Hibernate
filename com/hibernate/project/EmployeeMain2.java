package com.hibernate.project;

import com.hibernate.dao.EmployeeAddDao;
import com.hibernate.datamodel.Address;
import com.hibernate.datamodel.EmployeeAddress;
//Component mapping between Employee and address
public class EmployeeMain2 {
public static void main(String args[])
{
	EmployeeAddDao ME = new EmployeeAddDao();
	Address address1 = ME.addAddress("Kondapur","Hyderabad","AP","532");
	Integer empID1 = ME.addEmployeeAddress("Manoj", "Kumar", address1);
	 ME.listEmployees();
}
}