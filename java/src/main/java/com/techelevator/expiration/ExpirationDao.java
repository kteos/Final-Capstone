package com.techelevator.expiration;

import java.util.List;

public interface ExpirationDao {
	
	void createExpiration(List<Expiration> expirations);
	List<Expiration>getExpirations();
	Expiration updateExpiration(Expiration expiration);

}
