package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.IPersonService;

@RestController
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired(required=true)
	private IPersonService personService;
	
	public void setPersonService(IPersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = PersonRestURIConstants.ADD_PERSON, method = RequestMethod.POST)
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
	
	
	@RequestMapping(value = PersonRestURIConstants.GET_ALL_PERSONS, method = RequestMethod.GET)
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
	
	@RequestMapping(value = PersonRestURIConstants.GET_PERSON, method= RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int personId){
		logger.info("Getting persons with ID: "+personId);
		try{
			Person person = personService.getPersonById(personId);
			logger.info("Person with ID "+person.getName());
			return person;
		}catch(Exception e){
			logger.error("Person with ID "+personId+" not found.",e);
		}
		return null;
	}
	
	@RequestMapping(value = PersonRestURIConstants.DELETE_PERSON, method = RequestMethod.PUT)
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
