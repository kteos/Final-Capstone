package com.techelevator.email;

import io.jsonwebtoken.io.IOException;
import kong.unirest.json.JSONException;

public interface SendGridDao {
	void sendEmail( String user );
//	String jsonBuilder();
}
