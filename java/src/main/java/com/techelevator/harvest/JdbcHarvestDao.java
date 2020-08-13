package com.techelevator.harvest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHarvestDao implements HarvestDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcHarvestDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createHarvests(Harvest[] harvest , String userName) {
		int userId = getUserId(userName);
		

		for (Harvest harvest2 : harvest) {
			String select = "SELECT id, crop, direct_seed_to_harvest_time FROM harvest Where crop = ?";
			SqlRowSet crop = jdbcTemplate.queryForRowSet(select, harvest2.getCrop().toLowerCase());
			
			if ( crop.next()) {
				String update = "UPDATE harvest SET  direct_seed_to_harvest_time = ? WHERE crop  = ?";
				jdbcTemplate.update(update, harvest2.getDirectSeedToHarvestTime(), harvest2.getCrop().toLowerCase());
				
				
			} else {
				String sql = "INSERT INTO harvest (id, crop, direct_seed_to_harvest_time) VALUES (default, ?, ?) returning id";
				SqlRowSet row = jdbcTemplate.queryForRowSet(sql, harvest2.getCrop().toLowerCase(), harvest2.getDirectSeedToHarvestTime());
				while (row.next()) {
					harvest2.setId(row.getInt("id"));
				}
				String insertJoins = "INSERT INTO users_harvest (user_id, harvest_id) VALUES (?, ?)";
				jdbcTemplate.update(insertJoins, userId, harvest2.getId());
				
				
			}

		}

	}
	
	public  List<Harvest> cropNames(String username){
		List<Harvest> crops = new ArrayList<Harvest>();
		int userId = getUserId(username);
		String select = "Select harvest.id , harvest.crop , harvest.direct_seed_to_harvest_time from harvest join users_harvest on users_harvest.harvest_id = harvest.id where user_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(select, userId);
		
		while(rows.next()) {
			Harvest harvest= new Harvest();
			harvest.setId(rows.getInt("id"));
			harvest.setCrop(rows.getString("crop"));
			harvest.setDirectSeedToHarvestTime(rows.getInt("direct_seed_to_harvest_time"));
			crops.add(harvest);
		}
		return crops;
	}

	@Override
	public Harvest updateHarvest(Harvest harvest, String username) {
		int userid = getUserId(username);
		String update = "UPDATE harvest SET crop = ? , direct_seed_to_harvest_time = ? WHERE id = (select harvest_id from users_harvest where harvest_id = ? and user_id = ?)";
		jdbcTemplate.update(update, harvest.getCrop(), harvest.getDirectSeedToHarvestTime(), harvest.getId(),userid);
		return harvest;
	}
	
	
	
	
	private int getUserId(String user) {
		int userId = 0;
		String getUserId = "SELECT user_id FROM users Where username = ?";
		SqlRowSet getId = jdbcTemplate.queryForRowSet(getUserId, user);
		while (getId.next()) {
			userId = getId.getInt("user_id");
		}

		return userId;

	}
}


