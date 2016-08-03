package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ICategoryDAO;
import com.journaldev.spring.model.Category;
import com.journaldev.spring.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDAO;
	
	public void setCategoryDAO(ICategoryDAO categoryDAO){
		this.categoryDAO = categoryDAO;
	}
	
	@Override
	@Transactional
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		this.categoryDAO.addCategory(category);
	}

	@Override
	@Transactional
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		this.categoryDAO.updateCategory(category);
	}

	@Override
	@Transactional
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return this.categoryDAO.listCategory();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void removeCategory(int id) {
		// TODO Auto-generated method stub
		this.categoryDAO.removeCategory(id);
	}

}
