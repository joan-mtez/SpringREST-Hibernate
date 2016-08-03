package com.journaldev.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.IStockDAO;
import com.journaldev.spring.model.Category;
import com.journaldev.spring.model.Stock;

@Repository
public class StockDAOImpl implements IStockDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stock);
		logger.info("Stock saved successfully, Stock Details "+stock.toString());
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(stock);
		logger.info("Category saved successfully, Category Details "+stock.toString());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stock> listStock() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Stock> stockList = session.createQuery("from Stock").list();
		for(Stock s : stockList){
			logger.info("Category List::"+s.toString());
		}
		return stockList;	
		}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Stock stock =null;
		try{
			stock = (Stock) session.load(Stock.class,new Integer(id));
			logger.info("Stock loaded successfully, Stock details="+stock.toString());
		}catch(Exception e){
			
		}
		return stock;	
		}

	@Override
	public void removeStock(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Stock stock = (Stock) session.load(Stock.class, new Integer(id));
		if(null != stock){
			session.delete(stock);
		}
		logger.info("Category deleted successfully, Category details="+stock.toString());
	}

}
