package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.hibernate.config.HibernateMapUtil;
import com.hibernate.datamodel.Employee;

public class EmployeeDao {
	public static Employee add(Employee emp)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		return emp;
		
	}
	public static Employee edit(Employee emp)
	
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp_up=session.get(Employee.class,3);
		emp_up.setFirstName(emp.getFirstName());
		session.update(emp_up);
		session.getTransaction().commit();
		emp_up=session.get(Employee.class,3);
		session.close();
		return emp_up;
		
	}
	
	public static Employee get(int no)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		Employee emp=session.get(Employee.class,no);
		session.close();
		return emp;
	}
	
	public static List<Employee> loadAllData() {
		Session session=HibernateMapUtil.getSessionFactory().openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
	    criteria.from(Employee.class);
	    List<Employee> data = session.createQuery(criteria).getResultList();
	    session.close();
	    return data;
	  }
	
	public static void delete(int no)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp_up=session.get(Employee.class,no);
		session.delete(emp_up); 
		session.getTransaction().commit();
		session.close();
		
	}
	

}
