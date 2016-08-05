package com.journaldev.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department", catalog="hibernate_examples")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private int id;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	@Column(name="")
	
	@OneToMany(mappedBy="department")
	private List<EmployeePerDept> employees;
	
	public List<EmployeePerDept> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeePerDept> employees) {
		this.employees = employees;
	}
	public Department(int id, String departmentName, List<EmployeePerDept> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	
	public Department() {
		super();
		this.id = 0;
		this.departmentName = "";
	}
	
}
