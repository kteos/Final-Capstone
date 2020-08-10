package com.techelevator.sale;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcSaleDao implements SaleFormDao {

	private JdbcTemplate jd;
	
	 public JdbcSaleDao( JdbcTemplate jd) {
		this.jd = jd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void insertSale(SaleForm sale) {
		String insert = "INSERT INTO sales (id, product, amount, howsold) VALUES (default, ?, ?, ?) returning id";
		SqlRowSet id = jd.queryForRowSet(insert, sale.getProduct(), sale.getAmount(), sale.getHowSold());
		while( id.next()) {
			sale.setId(id.getInt("id"));
		}
		
	}

}
