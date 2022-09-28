package com.app.service;

import com.app.pojos.Stock;

public interface IStockService {

	
	Stock getById(int stock_id); 
	
	Stock addStock(Stock newStock); 
	
	
}
