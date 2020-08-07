package com.techelevator.expiration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcExpirationDao implements ExpirationDao {

	private JdbcTemplate jd;

	public JdbcExpirationDao(JdbcTemplate jdbcTemplate) {
		this.jd = jdbcTemplate;
	}

	public void createExpiration(List<Expiration> expirations) {
		String insert = "INSERT INTO expiration (id, crop, days_to_expire) VALUES (default, ?, ?) RETURNING id";
		String update = "UPDATE expiration SET  days_to_expire = ? WHERE crop = ?";

		for (Expiration expiration : expirations) {
			String select = "SELECT id, crop, days_to_expire FROM expiration WHERE crop = ?";
			SqlRowSet rows = jd.queryForRowSet(select, expiration.getCrop());
			if (rows.next()) {
				jd.update(update, expiration.getDaysToExpire(), expiration.getCrop());
			} else {
				SqlRowSet id = jd.queryForRowSet(insert, expiration.getCrop(), expiration.getDaysToExpire());
				while (id.next()) {
					expiration.setId(id.getInt("id"));
				}
			}

		}

	}

	@Override
	public List<Expiration> getExpirations() {
		List<Expiration> fullList = new ArrayList<Expiration>();
		String getCrops = "SELECT id, crop, days_to_expire FROM expiration";
		SqlRowSet rows = jd.queryForRowSet(getCrops);
		while (rows.next()) {
			Expiration ex = new Expiration();
			ex.setId(rows.getInt("id"));
			ex.setCrop(rows.getString("crop"));
			ex.setDaysToExpire(rows.getInt("days_to_expire"));
			fullList.add(ex);
		}

		return fullList;
	}

	@Override
	public Expiration updateExpiration(Expiration expiration) {
		String update = "UPDATE expiration SET  crop = ?, days_to_expire = ? WHERE id = ?";
		jd.update(update, expiration.getCrop(), expiration.getDaysToExpire(), expiration.getId());
		
		return expiration;
	}

}
