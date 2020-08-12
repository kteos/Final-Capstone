package com.techelevator.expiration;

import java.util.List;

public interface ExpirationDao {
	
	void createExpiration(List<Expiration> expirations, String userName);
	List<Expiration>getExpirations(String userName);
	Expiration updateExpiration(Expiration expiration, String userName);

}
