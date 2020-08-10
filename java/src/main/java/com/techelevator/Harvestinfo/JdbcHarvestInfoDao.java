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
	public void insertHarvestInfo(HarvestInfo harvestInfo) {
		String insert = "INSERT INTO harvest_info (id, area_identifier, crop, count_, weight_) VALUES (default, ?, ?, ?, ?) returning id";
		SqlRowSet id = jd.queryForRowSet(insert, harvestInfo.getAreaIdentifier(), harvestInfo.getCrop(), harvestInfo.getCount(), harvestInfo.getWeight());
		while ( id.next() ) {
			harvestInfo.setId(id.getInt("id"));
		}
		
	}

}
