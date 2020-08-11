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
	
	public void createCrops(List<Crops> crops) {
		String insert = "INSERT INTO crops (id, area, crop, planting_date) VALUES (default, ?, ?, ?)";
		String update = "update crops set area = ?, planting_date = ? where crop = ?";
		String select = "SELECT id, area, crop, planting_date FROM crops where crop = ?";
		for(Crops c : crops) {
			SqlRowSet rows = jd.queryForRowSet(select, c.getCrop());
			if(rows.next()) {
				jd.update(update, c.getArea(), c.getPlantingDate(), c.getCrop());
			} else {
				jd.update(insert, c.getArea(), c.getCrop(), c.getPlantingDate());
			}
		}
	}
	
	public List<Crops> getAllCrops(){
		List<Crops> crops = new ArrayList<Crops>();
		String select = "SELECT id, area, crop, planting_date FROM crops";
		SqlRowSet rows = jd.queryForRowSet(select);
		
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
	
	public void updateCrops(Crops crop) {
		String update = "update crops set area = ?, crop = ?, planting_date = ? where id = ?";
		jd.update(update, crop.getArea(), crop.getCrop(),crop.getPlantingDate(),crop.getId());
	}
}
