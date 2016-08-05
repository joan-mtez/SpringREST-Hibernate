package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.IEmployeeDAO;
import com.journaldev.spring.model.EmployeePerDept;
import com.journaldev.spring.service.IEmployeePerDeptService;

@Service
public class EmployeePerDeptServiceImpl implements IEmployeePerDeptService {

	@Autowired
	public IEmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(IEmployeeDAO employeeDAO){
		 this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<EmployeePerDept> getEmployeesPerDepartment() {
		// TODO Auto-generated method stub
		return this.employeeDAO.getEmployeesPerDepartment();
	}

}
