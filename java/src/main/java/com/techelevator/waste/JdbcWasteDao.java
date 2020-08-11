package com.techelevator.waste;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcWasteDao implements WasteDao {

	private JdbcTemplate jd;	
	
	 public JdbcWasteDao( JdbcTemplate jd) {
		this.jd = jd;
	}
	
	
	
	@Override
	public void insertWaste(Waste waste) {
		String insert = "INSERT INTO wasteinfo (id, crop, reason) VALUES (default, ?, ?) returning id";
		SqlRowSet id = jd.queryForRowSet(insert, waste.getCrop(), waste.getReason());
		while (id.next()) {
			waste.setId(id.getInt("id"));
		}
		
	}

}
