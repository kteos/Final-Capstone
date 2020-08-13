package com.techelevator.Harvestinfo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcHarvestInfoDao implements HarvestInfoDao {

	private JdbcTemplate jd;		
	
	public JdbcHarvestInfoDao(JdbcTemplate jd) {

		this.jd = jd;

	}
	
	
	
	@Override
	public void insertHarvestInfo(HarvestInfo harvestInfo , String user) {
		int userId = getUserId(user);
		String insertJoins = "INSERT INTO users_harvestinfo (user_id, harvestinfo_id) VALUES (?, ?)";
		String insert = "INSERT INTO harvest_info (id, area_identifier, crop, count_, weight_) VALUES (default, ?, ?, ?, ?) returning id";
		SqlRowSet id = jd.queryForRowSet(insert, harvestInfo.getAreaIdentifier(), harvestInfo.getCrop(), harvestInfo.getCount(), harvestInfo.getWeight());
		while ( id.next() ) {
			harvestInfo.setId(id.getInt("id"));
		}
		jd.update(insertJoins, userId , harvestInfo.getId());
		
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
