package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.entity.Employee;



public class HibernateManager {
	static Session session=null;
	static 
	{
		session = new Configuration().
				configure().
				addAnnotatedClass(Employee.class).
				buildSessionFactory().
				openSession();
		
	}
	public void add(Employee e) 
	{
		Transaction t = session.beginTransaction();
		session.persist(e);//save
		t.commit();
	}
	public Employee getUserById(int id)
	{
		return session.get(Employee.class, id);
	}
	public void updateEmployee(Employee e) 
	{
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		System.out.println("data updated");
	}
	public void delete(int id) {
		session.beginTransaction();
		Employee e=session.get(Employee.class, id);
		if (e!=null) {
			session.delete(e);
			System.out.println("object deleted");
		}
		else {
			System.out.println("no such record");
		}
		session.getTransaction().commit();
	}
	public List<Employee> getAllEmployee() {
		String hql="from Employee";
		Query<Employee> query=session.createQuery(hql,Employee.class);
		return query.list();
	}
		
	

}
