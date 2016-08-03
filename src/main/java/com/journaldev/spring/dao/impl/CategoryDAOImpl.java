package com.journaldev.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.ICategoryDAO;
import com.journaldev.spring.model.Category;

@Repository
public class CategoryDAOImpl implements ICategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		logger.info("Category saved successfully, Category Details "+category.toString());
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
		logger.info("Category saved successfully, Category Details "+category.toString());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category").list();
		for(Category c : categoryList){
			logger.info("Category List::"+c.toString());
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Category category =null;
		try{
			category = (Category) session.load(Category.class,new Integer(id));
			logger.info("Category loaded successfully, Category details="+category.toString());
		}catch(Exception e){}
		return category;
	}

	@Override
	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = (Category) session.load(Category.class, new Integer(id));
		if(null != category){
			session.delete(category);
		}
		logger.info("Category deleted successfully, Category details="+category.toString());
	}

}
