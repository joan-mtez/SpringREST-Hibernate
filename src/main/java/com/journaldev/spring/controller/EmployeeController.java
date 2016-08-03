package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Category;
import com.journaldev.spring.model.Employee;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Stock;
import com.journaldev.spring.service.ICategoryService;
import com.journaldev.spring.service.IPersonService;
import com.journaldev.spring.service.IStockService;

/**
 * Handles requests for the Employee service.
 */
//@Controller
@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired(required=true)
	private IPersonService personService;
	
	@Autowired(required=true)
	private IStockService stockService;
	
	public void setPersonService(IPersonService ps){
		this.personService = ps;
	}
	
	@Autowired(required=true)
	private ICategoryService categoryService;
	
	public void setCategoryService(ICategoryService ps){
		this.categoryService = ps;
	}
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	@RequestMapping(value = EmpRestURIConstants.ADD_PERSON, method = RequestMethod.POST)
	public @ResponseBody boolean addNewPerson(@RequestBody Person person) {
		logger.info("Start Adding Person into DB");
		boolean added = false;
		try {
			personService.addPerson(person);
			added = true;
		}catch(Exception e){
			logger.error("Person "+person.getName()+" not added.",e);
		}
		return added;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return empData.get(empId);
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_PERSONS, method = RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons() {
		logger.info("Start getting all Persons from DB");
		List<Person> persons = new ArrayList<Person>();
		try {
			persons.addAll(personService.listPersons());
		}catch(Exception e){
			logger.error("Error loading persons from DB.",e);
		}
		return persons;
	}
	
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_STOCKS, method = RequestMethod.GET)
	public @ResponseBody List<Stock> getAllStocks() {
		logger.info("Start getting all Persons from DB");
		List<Stock> stocks = new ArrayList<Stock>();
		try {
			stocks.addAll(stockService.listStock());
		}catch(Exception e){
			logger.error("Error loading persons from DB.",e);
		}
		return stocks;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_CATEGORIES, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategories() {
		logger.info("Start getting all Persons from DB");
		List<Category> categories = new ArrayList<Category>();
		try {
			categories.addAll(categoryService.listCategory());
		}catch(Exception e){
			logger.error("Error loading persons from DB.",e);
		}
		return categories;
	}
	
	
	/*
	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return empData.get(empId);
	}*/
	
	@RequestMapping(value = EmpRestURIConstants.GET_PERSON, method= RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int personId){
		logger.info("Getting persons with ID: "+personId);
		Person person = null;
		try{
			person = personService.getPersonById(personId);
			logger.info("Person with ID "+person.getName());
		}catch(Exception e){
			logger.error("Person with ID "+personId+" not found.",e);
		}
		return person;
	}
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_PERSON, method = RequestMethod.PUT)
	public @ResponseBody boolean deletePerson(@PathVariable("id") int personId) {
		logger.info("Start removing Person from DB");
		boolean deleted = false;
		try{
			personService.removePerson(personId);
			deleted = true;
		}
		catch(Exception e){
			logger.error("Error deleting person with id " + personId,e);
		}
		return deleted;
	}
	
}
