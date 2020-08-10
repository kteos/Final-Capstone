package com.techelevator.sale;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SaleController {
	private SaleFormDao dao;
	
	
	public SaleController( SaleFormDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(path= "/sale/input" , method=RequestMethod.POST)
	public void insertSale(@RequestBody SaleForm sale) {
		dao.insertSale(sale);
	}

}
