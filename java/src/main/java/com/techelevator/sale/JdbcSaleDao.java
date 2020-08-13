package com.techelevator.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	public void insertSale(SaleForm sale , String user) {
		int userId = getUserId(user);
		String insert = "INSERT INTO sales (id, product, amount, howsold) VALUES (default, ?, ?, ?) returning id";
		String insertJoins = "INSERT INTO users_sale (user_id, sale_id) VALUES (?, ?)";
		SqlRowSet id = jd.queryForRowSet(insert, sale.getProduct().toLowerCase(), sale.getAmount(), sale.getHowSold());
		while( id.next()) {
			sale.setId(id.getInt("id"));
		}
		
		jd.update(insertJoins, userId , sale.getId());
		
	}
	
	
	private int getUserId(String user) {
		int userId = 0;
		String getUserId = "SELECT user_id FROM users Where username = ?";
		SqlRowSet getId = jd.queryForRowSet(getUserId, user);
		while (getId.next()) {
			userId = getId.getInt("user_id");
		}

		return userId;

	}












	@Override
	public List<SaleForm> getListOfSales(String user) {
		int userId = getUserId(user);
		List<SaleForm> fullList = new ArrayList<SaleForm>();
		String select = "select sales.product , sales.amount from sales join users_sale on users_sale.sale_id = sales.id where user_id = ?";
		SqlRowSet rows = jd.queryForRowSet(select, userId);
		while (rows.next()) {
			SaleForm sale = new SaleForm();
			sale.setProduct(rows.getString("product"));
			sale.setAmount((BigDecimal.valueOf(rows.getDouble("amount"))));
			fullList.add(sale);
		}
		
		return fullList;
	}

}
