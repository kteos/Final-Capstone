package com.techelevator.sale;

import java.util.List;

public interface SaleFormDao {
	
	void insertSale (SaleForm sale, String user);
	
	List<SaleForm> getListOfSales(String user);

}
