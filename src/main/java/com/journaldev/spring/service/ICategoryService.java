package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Category;

public interface ICategoryService {

	public void addCategory(Category category);
	public void updateCategory(Category category);
	public List<Category> listCategory();
	public Category getCategoryById(int id);
	public void removeCategory(int id);
	
}
