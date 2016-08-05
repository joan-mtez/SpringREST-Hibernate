package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.EmployeePerDept;

public interface IEmployeeDAO {

	public List<EmployeePerDept> getEmployeesPerDepartment();
	
}
