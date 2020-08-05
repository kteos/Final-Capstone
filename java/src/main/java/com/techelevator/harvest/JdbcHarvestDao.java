package com.techelevator.harvest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHarvestDao implements HarvestDao{
//	String filePath = "harvestTest.csv";
	private JdbcTemplate jdbcTemplate;
	
	public JdbcHarvestDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void createHarvests(String path) throws FileNotFoundException{
//		path = "/Users/zkolker/Final_Capstone/team-charlie-java-blue-capstone/java/harvestTest.csv";
		File file = new File(path);
		try(Scanner harvestList = new Scanner(file)){
			String currentFile = harvestList.nextLine();
			String[] splitLines = currentFile.split("\\|");
			Harvest harvest = new Harvest(splitLines[0], Integer.parseInt(splitLines[1]));
			String sql = "INSERT INTO harvest (id, crop, direct_seed_to_harvest_time) VALUES (default, ?, ?) returning id";
			SqlRowSet row = jdbcTemplate.queryForRowSet(sql, harvest.getCrop(), harvest.getDirectSeedToHarvestTime());
			while(row.next()) {
				harvest.setId(row.getInt("id"));
			}
		}
			
		
	}

}
