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
	public void insertLossInfo(Loss loss) {
		String insert = "INSERT INTO lossinfo (id, crop, loss_reason) VALUES (default, ?, ?) Returning id";
		SqlRowSet id = jd.queryForRowSet(insert, loss.getCrop() , loss.getLossReason());
		
		while ( id.next() ) {
			loss.setId(id.getInt("id"));
		}
		
	}

}
