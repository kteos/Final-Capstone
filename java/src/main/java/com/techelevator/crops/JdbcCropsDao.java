package com.techelevator.crops;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCropsDao implements CropsDao{
	
	private JdbcTemplate jd;

	public JdbcCropsDao(JdbcTemplate jdbcTemplate) {
		this.jd = jdbcTemplate;
	}
	
	public void createCrops(List<Crops> crops , String user) {
		int userId = getUserId(user);
		String insertJoins = "INSERT INTO users_crop (user_id, crop_id) VALUES (?, ?)";
		String insert = "INSERT INTO crops (id, area, crop, planting_date) VALUES (default, ?, ?, ?) returning id";
		String update = "update crops set area = ?, planting_date = ? where crop = ? ";
		String select = "SELECT id, area, crop, planting_date FROM crops where crop = ?";
		for(Crops c : crops) {
			SqlRowSet rows = jd.queryForRowSet(select, c.getCrop());
			if(rows.next()) {
				jd.update(update, c.getArea(), c.getPlantingDate(), c.getCrop());
			} else {
				SqlRowSet id =jd.queryForRowSet(insert, c.getArea(), c.getCrop(), c.getPlantingDate());
				while ( id.next() ) {
					c.setId(id.getInt("id"));
				}
				jd.update(insertJoins, userId, c.getId());
				
			}
		}
	}
	
	public List<Crops> getAllCrops(String user){
		int userId = getUserId(user);
		List<Crops> crops = new ArrayList<Crops>();
		String select = "select crops.id,  crops.area , crops.planting_date , crops.crop from crops join users_crop on users_crop.crop_id = crops.id where user_id = ?";
		SqlRowSet rows = jd.queryForRowSet(select , userId);
		
		while(rows.next()) {
			Crops crop = new Crops();
			crop.setId(rows.getInt("id"));
			crop.setArea(rows.getString("area"));
			crop.setCrop(rows.getString("crop"));
			crop.setPlantingDate(rows.getDate("planting_date").toLocalDate());
			crops.add(crop);
		}
		return crops;
	}
	
	public void updateCrops(Crops crop , String user) {
		int userId = getUserId(user);
		String update = "UPDATE crops SET  area = ?, crop = ?, planting_date = ? WHERE id = (select crop_id from users_crop where user_id = ? and crop_id = ?)";
		jd.update(update, crop.getArea(), crop.getCrop(),crop.getPlantingDate(), userId , crop.getId());
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
