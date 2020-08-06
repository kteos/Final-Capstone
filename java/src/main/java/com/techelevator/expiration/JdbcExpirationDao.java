package com.techelevator.expiration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcExpirationDao implements ExpirationDao {
	
	private JdbcTemplate jd;
	
	public JdbcExpirationDao ( JdbcTemplate jdbcTemplate) {
		this.jd = jdbcTemplate;
	}
	
	
	
	public void createExpiration(List<Expiration> expirations) {
		String insert = "insert into expiration values (default , ?)";
		String insertJoins = "insert into harvest_expiration values ((select id from expiration where days_to_expire = ?),(select id from harvest where crop = ?))";
		String getId = "select id from expiration where days_to_expire = ?";
		String checkJoin = "select expiration_id from harvest_expiration where harvest_id = (select id from harvest where crop = ?)";
		for (Expiration expiration : expirations) {
			SqlRowSet id = jd.queryForRowSet(getId, expiration.getDaysToExpire());
			SqlRowSet joins = jd.queryForRowSet(checkJoin, expiration.getCrop());
			if(!joins.next()) {
			if( id.next()) {
				jd.update(insertJoins, expiration.getDaysToExpire(), expiration.getCrop().toLowerCase());
				
			}else {
			jd.update(insert, expiration.getDaysToExpire());
			jd.update(insertJoins, expiration.getDaysToExpire(), expiration.getCrop().toLowerCase());
			}
		}
			
		}
	
		
	}



	@Override
	public List<Expiration> getExpirations() {
		List<Expiration> fullList = new ArrayList<Expiration>();
		String getCrops = "select harvest.crop, expiration.days_to_expire from harvest join harvest_expiration on harvest.id = harvest_expiration.harvest_id join expiration on harvest_expiration.expiration_id = expiration.id";
		SqlRowSet rows =  jd.queryForRowSet(getCrops);
		while( rows.next() ) {
			Expiration ex = new Expiration();
			ex.setCrop(rows.getString("crop"));
			ex.setDaysToExpire(rows.getInt("days_to_expire"));
			fullList.add(ex);
		}
		
		return fullList;
	}
	
	

}
