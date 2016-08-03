package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Stock;


public interface IStockDAO {

	public void addStock(Stock stock);
	public void updateStock(Stock stock);
	public List<Stock> listStock();
	public Stock getStockById(int id);
	public void removeStock(int id);
	
}
