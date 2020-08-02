package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hibernate.config.HibernateMapUtil;
import com.hibernate.datamodel.Owner;
import com.hibernate.datamodel.Car;

public class OwnerDao {
	public static Owner add(Owner owner)
	{
		System.out.println("inside add");
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(owner);
		owner.getCars().forEach((Car car)->{session.save(car);});
		System.out.println("inside add");
		session.getTransaction().commit();
		System.out.println("inside add");
		session.close();
		return owner;
		
	}
	public static Owner edit(Owner owner)
	
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//editing 3 rd owner
		session.update(owner);
		session.getTransaction().commit();
		session.close();
		return owner;
		
	}
	
	public static Owner get(Long no)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner=session.get(Owner.class,no);
		owner.getCars(); //to load proxy objects
		session.getTransaction().commit();
		session.close();
		return owner;
	}
	
	public static List<Owner> loadAllData() {
		Session session=HibernateMapUtil.getSessionFactory().openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Owner> criteria = builder.createQuery(Owner.class);
	    criteria.from(Owner.class);
	    List<Owner> data = session.createQuery(criteria).getResultList();
	    data.forEach((Owner owner)->{owner.getCars();}); //to load proxy objects inside session
	    session.close();
	    return data;
	  }
	
	public static void delete(Long no)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner_up=session.get(Owner.class,no);
		session.delete(owner_up); 
		session.getTransaction().commit();
		session.close();
		
	}
	public static List<Car>getAllCarHQL()
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM com.hibernate.datamodel.Car";
		Query<Car> query = session.createQuery(hql);
		List<Car> results = query.list();
		session.getTransaction().commit();
		session.close();
		return results;
	}
	public static List<Car>getLimitCarHQL()//to display only reg_no and manufacturer
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select C.reg_no ,C.Manufacturer FROM com.hibernate.datamodel.Car C";
		Query<Car> query = session.createQuery(hql);
		List<Car> results = query.list();
		session.getTransaction().commit();
		session.close();
		return results;
	}
	
	public static List<Car>getLimitCarHQL(String reg_no)//to display only reg_no and manufacturer
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM com.hibernate.datamodel.Car C where C.reg_no like :reg_no";
		Query<Car> query = session.createQuery(hql);
		query.setParameter("reg_no",reg_no);
		List<Car> results = query.list();
		session.getTransaction().commit();
		session.close();
		return results;
	} 
	//to display only manufacturer whose name starts with 'V'
	public static List<Car> getCarManufacturer(){
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select C.Manufacturer FROM com.hibernate.datamodel.Car C where C.Manufacturer like :reg_no";
		Query<Car> query = session.createQuery(hql);
		query.setParameter("reg_no","v%");
		List<Car> results = query.list();
		session.getTransaction().commit();
		session.close();
		return results;
	}
	//criteria Query
	public static int getCountofColor(String color)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session.createCriteria(Car.class).add(Restrictions.like("color", color)).list().size();
	}
	public static int getCountofRegno(String regno)
	{
		Session session=HibernateMapUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session.createCriteria(Car.class).add(Restrictions.like("reg_no","%"+regno+"%")).list().size();
	}
}
