package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Category;
import com.journaldev.spring.model.Stock;
import com.journaldev.spring.service.ICategoryService;
import com.journaldev.spring.service.IStockService;

@RestController
public class StockCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(StockCategoryController.class);
	
	@Autowired(required=true)
	private IStockService stockService;
	
	@Autowired(required=true)
	private ICategoryService categoryService;
	
	public void setStockService(IStockService stockService){
		this.stockService = stockService;
	}
	
	public void setCategoryService(ICategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = StockCatRestURIConstants.GET_ALL_STOCKS, method = RequestMethod.GET)
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
	
	@RequestMapping(value = StockCatRestURIConstants.GET_ALL_CATEGORIES, method = RequestMethod.GET)
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
	
}
