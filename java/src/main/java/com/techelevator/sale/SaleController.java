package com.techelevator.sale;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class SaleController {
	private SaleFormDao dao;
	
	
	public SaleController( SaleFormDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(path= "/sale/input" , method=RequestMethod.POST)
	public void insertSale(@RequestBody SaleForm sale , Principal user) {
		dao.insertSale(sale , user.getName());
	}
	
	@RequestMapping(path = "/sale", method= RequestMethod.GET)
	public List<SaleForm> getAllSales( Principal user){
		return dao.getListOfSales(user.getName());
	}

}
