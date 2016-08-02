package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Category;

public interface CategoryDAO {

	public void addCategory(Category category);
	public void updateCategory(Category category);
	public List<Category> listCategory();
	public Category getCategoryById(int id);
	public void removeCategory(int id);
	
}
