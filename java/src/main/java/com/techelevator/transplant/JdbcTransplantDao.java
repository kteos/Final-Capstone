package com.techelevator.transplant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcTransplantDao implements TransplantDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTransplantDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createTransplants( Transplant[] transplant , String user ) {
		
		int userId = getUserId(user);
		String insertJoins = "INSERT INTO users_transplant (user_id, transplant_id) VALUES (?, ?)";
		
		for (Transplant item : transplant) {
			String select = "SELECT id, crop, direct_seed_to_transplant_time, transplant_to_harvest_time FROM transplant Where crop = ?";
			SqlRowSet crop = jdbcTemplate.queryForRowSet(select, item.getCrop().toLowerCase());
			
			if ( crop.next()) {
				String update = "UPDATE transplant SET direct_seed_to_transplant_time = ?, transplant_to_harvest_time = ? WHERE crop  = ?";
				jdbcTemplate.update(update, item.getDirectSeedToTransplantTime(), item.getTransplantToHarvestTime(), item.getCrop().toLowerCase());
				
				
			} else {
				String sql = "INSERT INTO transplant (id, crop, direct_seed_to_transplant_time, transplant_to_harvest_time) VALUES (default, ?, ?, ?) returning id";
				SqlRowSet row = jdbcTemplate.queryForRowSet(sql, item.getCrop().toLowerCase(), item.getDirectSeedToTransplantTime(), item.getTransplantToHarvestTime());
				while (row.next()) {
					item.setId(row.getInt("id"));
				}
				jdbcTemplate.update(insertJoins, userId, item.getId());
				
				
			}

		}

	}
		
	public  List<Transplant> listTransplant( String user){
		int userId = getUserId(user);
		List<Transplant> transplantList = new ArrayList<Transplant>();
		String select = "select transplant.id , transplant.crop , transplant.direct_seed_to_transplant_time , transplant.transplant_to_harvest_time from transplant join users_transplant on users_transplant.transplant_id = transplant.id where user_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(select , userId);
		
		while(rows.next()) {
			Transplant transplant = new Transplant();
			transplant.setId(rows.getInt("id"));
			transplant.setCrop(rows.getString("crop"));
			transplant.setDirectSeedToTransplantTime(rows.getInt("direct_seed_to_transplant_time"));
			transplant.setTransplantToHarvestTime(rows.getInt("transplant_to_harvest_time"));
			transplantList.add(transplant);
		}
		return transplantList;
	}
	

	public Transplant updateTransplant(Transplant transplant , String user) {
		int userId = getUserId(user);
		String update = "UPDATE transplant SET  crop = ?, direct_seed_to_transplant_time = ?, transplant_to_harvest_time = ? WHERE id = (select transplant_id from users_transplant where user_id = ? and transplant_id = ?)";
		jdbcTemplate.update(update, transplant.getCrop(), transplant.getDirectSeedToTransplantTime(), transplant.getTransplantToHarvestTime(), userId,  transplant.getId());
		return transplant;
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
