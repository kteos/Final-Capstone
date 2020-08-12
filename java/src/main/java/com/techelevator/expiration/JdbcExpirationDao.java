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

	public void createExpiration(List<Expiration> expirations, String userName) {
		String insert = "INSERT INTO expiration (id, crop, days_to_expire) VALUES (default, ?, ?) RETURNING id";
		String update = "UPDATE expiration SET  days_to_expire = ? WHERE crop = ?";
		String insetJoins = "INSERT INTO users_expiration (user_id, expiration_id) VALUES (?, ?)";
		int userId = getUserId(userName);

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
				jd.update(insetJoins, userId, expiration.getId());
			}

		}

	}

	@Override
	public List<Expiration> getExpirations( String userName ) {
		int userId = getUserId(userName);
		List<Expiration> fullList = new ArrayList<Expiration>();
		String getCrops = "select expiration.id , expiration.crop , expiration.days_to_expire from expiration join users_expiration on users_expiration.expiration_id = expiration.id where user_id = ?";
		SqlRowSet rows = jd.queryForRowSet(getCrops, userId);
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
	public Expiration updateExpiration(Expiration expiration , String userName) {
		int userId = getUserId(userName);
		String update = "UPDATE expiration SET  crop = ?, days_to_expire = ? WHERE id = (select expiration_id from users_expiration where user_id = ? and expiration_id = ?)";
		jd.update(update, expiration.getCrop(), expiration.getDaysToExpire(), userId,  expiration.getId());
		
		return expiration;
	}
	
	
	private int getUserId(String user) {
		int userId = 0;
		String getUserId = "SELECT user_id FROM users Where username = ?";
		SqlRowSet getId = jd.queryForRowSet(getUserId, user);
		while ( getId.next()) {
			 userId = getId.getInt("user_id");
		}
		
		
		return userId;
		
	}

}
