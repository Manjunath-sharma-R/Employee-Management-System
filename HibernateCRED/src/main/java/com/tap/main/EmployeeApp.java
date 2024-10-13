package com.tap.main;

import java.util.List;

import com.tap.entity.Employee;
import com.tap.manager.HibernateManager;

public class EmployeeApp {
	public static void main(String[] args) {
		
		HibernateManager hm=new HibernateManager();//object of hibernate
		//Employee e=new Employee(3,"manju","associate trainee",30000);//object of employee
		//hm.connect();
		//hm.add(e);
		//System.out.println("object added");
		//Employee e1=hm.getUserById(2);
		//System.out.println(e1);
		//Employee e=new Employee(1,"lavanya","associate trainee",30000);
		//hm.updateEmployee(e);
		//hm.delete(3);
		List<Employee> emps=hm.getAllEmployee();
		for(Employee e:emps) {
			System.out.println(e);
		}
		
	}

}
