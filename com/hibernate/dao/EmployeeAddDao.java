package com.hibernate.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.config.HibernateMapUtil;
import com.hibernate.datamodel.Address;
import com.hibernate.datamodel.EmployeeAddress;


public class EmployeeAddDao {
	public Address addAddress(String doorno, String city, String state, String pincode) {
	      Session session = HibernateMapUtil.getSessionFactory().openSession();
	      Address address = null;
	      
	      try {
	         session.beginTransaction();
	         address = new Address(doorno, city, state, pincode);
	         session.save(address); 
	         session.getTransaction().commit();
	      } catch (HibernateException e) {
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return address;
	   }

	   public Integer addEmployeeAddress(String fname, String lname, Address address){
	      Session session = HibernateMapUtil.getSessionFactory().openSession();
	      Integer EmployeeAddressID = null;
	      try {
	    	 session.beginTransaction();
	         EmployeeAddress EmployeeAddress = new EmployeeAddress(fname, lname, address);
	         EmployeeAddressID=(Integer) session.save(EmployeeAddress); 
	     
	      } catch (HibernateException e) {
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return EmployeeAddressID;
	   }

	   /* Method to list all the EmployeeAddresss detail */
	   public void listEmployeeAddresss( ){
	      Session session = HibernateMapUtil.getSessionFactory().openSession();
	      try {
	      
	         List EmployeeAddresss = session.createQuery("FROM EmployeeAddress").list(); 
	         for (Iterator iterator = EmployeeAddresss.iterator(); iterator.hasNext();){
	            EmployeeAddress EmployeeAddress = (EmployeeAddress) iterator.next(); 
	            System.out.print("First Name: " + EmployeeAddress.getFirstName()); 
	            System.out.print("  Last Name: " + EmployeeAddress.getLastName()); 
	            Address add = EmployeeAddress.getAddress();
	            System.out.println("Address ");
	            System.out.println("\t Door NO: " +  add.getDoorNo());
	            System.out.println("\tCity: " + add.getCity());
	            System.out.println("\tState: " + add.getState());
	            System.out.println("\tpincode: " + add.getPincode());
	         }
	       
	      } catch (HibernateException e) {
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to update salary for an EmployeeAddress */
	   public void updateEmployeeAddress(Integer EmployeeAddressID,String  firstName ){
	      Session session = HibernateMapUtil.getSessionFactory().openSession();
	      
	      try {
	        session.beginTransaction();
	         EmployeeAddress EmployeeAddress = (EmployeeAddress)session.get(EmployeeAddress.class, EmployeeAddressID); 
	         EmployeeAddress.setFirstName(firstName);
	         session.update(EmployeeAddress);
	
	      } catch (HibernateException e) {
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	

}
