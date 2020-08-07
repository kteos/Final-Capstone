package com.techelevator.transplant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.harvest.Harvest;

@Component
public class JdbcTransplantDao implements TransplantDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTransplantDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createTransplants( Transplant[] transplant ) {
		
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
				
			}

		}

	}
		
	public  List<Transplant> listTransplant(){
		List<Transplant> transplantList = new ArrayList<Transplant>();
		String select = "SELECT id, crop, direct_seed_to_transplant_time, transplant_to_harvest_time FROM transplant";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(select);
		
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

}
