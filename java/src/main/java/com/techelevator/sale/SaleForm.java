package com.techelevator.sale;

import java.math.BigDecimal;

public class SaleForm {
	private int id;
	private String product;
	private BigDecimal amount;
	private String howSold;
	
	
	
	public SaleForm () {
		
	}
	
	
	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getHowSold() {
		return howSold;
	}

	public void setHowSold(String howSold) {
		this.howSold = howSold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
