package com.techelevator.loss;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JdbcLoss implements LossDao{
	
	
	private JdbcTemplate jd;
	
	 public JdbcLoss( JdbcTemplate jd) {
		this.jd = jd;
	}

	@Override
	public void insertLossInfo(Loss loss , String user) {
		int userId = getUserId(user);
		String inserJoins = "INSERT INTO users_loss (user_id, loss_id) VALUES (?, ?)";
		String insert = "INSERT INTO lossinfo (id, crop, loss_reason) VALUES (default, ?, ?) Returning id";
		SqlRowSet id = jd.queryForRowSet(insert, loss.getCrop() , loss.getLossReason());
		
		while ( id.next() ) {
			loss.setId(id.getInt("id"));
		}
		jd.update(inserJoins, userId , loss.getId());
		
	}
	
	private int getUserId(String user) {
		int userId = 0;
		String getUserId = "SELECT user_id FROM users Where username = ?";
		SqlRowSet getId = jd.queryForRowSet(getUserId, user);
		while (getId.next()) {
			userId = getId.getInt("user_id");
		}

		return userId;

	}

}
