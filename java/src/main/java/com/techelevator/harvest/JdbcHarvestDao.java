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
	
	public void createHarvests(Harvest[] harvest) {
		

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
				
			}

		}

	}
	
	public  List<Harvest> cropNames(){
		List<Harvest> crops = new ArrayList<Harvest>();
		String select = "SELECT id, crop, direct_seed_to_harvest_time FROM harvest";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(select);
		
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
	public Harvest updateHarvest(Harvest harvest) {
		String update = "UPDATE harvest SET  crop = ?, direct_seed_to_harvest_time = ? WHERE id = ?";
		jdbcTemplate.update(update, harvest.getCrop(), harvest.getDirectSeedToHarvestTime(), harvest.getId());
		return harvest;
	}
}


