package com.techelevator.waste;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcWasteDao implements WasteDao {

	private JdbcTemplate jd;	
	
	 public JdbcWasteDao( JdbcTemplate jd) {
		this.jd = jd;
	}
	
	
	
	@Override
	public void insertWaste(Waste waste , String user) {
		int userId = getUserId(user);
		String insertJoins = "INSERT INTO users_waste (user_id, waste_id) VALUES (?, ?)";
		String insert = "INSERT INTO wasteinfo (id, crop, reason) VALUES (default, ?, ?) returning id";
		SqlRowSet id = jd.queryForRowSet(insert, waste.getCrop(), waste.getReason());
		while (id.next()) {
			waste.setId(id.getInt("id"));
		}
		jd.update(insertJoins, userId , waste.getId());
		
		
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

}
