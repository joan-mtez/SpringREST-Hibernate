package com.journaldev.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.IEmployeeDAO;
import com.journaldev.spring.model.EmployeePerDept;

@Repository
public class EmployeePerDeptDAOImpl implements IEmployeeDAO{

	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePerDept> getEmployeesPerDepartment() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<EmployeePerDept> categoryList = session.createQuery("from EmployeePerDept").list();
		return categoryList;
	}

}
