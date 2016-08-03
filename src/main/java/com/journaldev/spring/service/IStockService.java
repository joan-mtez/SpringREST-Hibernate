package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Stock;

public interface IStockService {

	public void addStock(Stock stock);
	public void updateStock(Stock stock);
	public List<Stock> listStock();
	public Stock getStockById(int id);
	public void removeStock(int id);
	
}
