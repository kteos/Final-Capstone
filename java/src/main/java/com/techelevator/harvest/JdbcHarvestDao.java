package com.techelevator.harvest;

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

	public void createHarvests(List<Harvest> harvest) {

		for (Harvest harvest2 : harvest) {
			String sql = "INSERT INTO harvest (id, crop, direct_seed_to_harvest_time) VALUES (default, ?, ?) returning id";
			SqlRowSet row = jdbcTemplate.queryForRowSet(sql, harvest2.getCrop(), harvest2.getDirectSeedToHarvestTime());
			while (row.next()) {
				harvest2.setId(row.getInt("id"));
			}

		}

	}
	
	private List<String> cropNames(){
		 names = new List<String>();
		return names;
	}
}


