package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.IStockDAO;
import com.journaldev.spring.model.Stock;
import com.journaldev.spring.service.IStockService;

@Service
public class StockServiceImpl implements IStockService{

	@Autowired
	private IStockDAO stockDAO;
	
	public void setService(IStockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Override
	@Transactional
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		this.stockDAO.addStock(stock);
	}

	@Override
	@Transactional
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		this.stockDAO.updateStock(stock);
	}

	@Override
	@Transactional
	public List<Stock> listStock() {
		// TODO Auto-generated method stub
		return this.stockDAO.listStock();
	}

	@Override
	@Transactional
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		return this.stockDAO.getStockById(id);
	}

	@Override
	@Transactional
	public void removeStock(int id) {
		// TODO Auto-generated method stub
		this.stockDAO.removeStock(id);
	}

}
