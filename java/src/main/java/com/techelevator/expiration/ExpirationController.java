package com.techelevator.expiration;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ExpirationController {
	
	
	private ExpirationDao dao;
	
	public ExpirationController ( ExpirationDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping( path= "/expiration/upload", method= RequestMethod.POST)
	public void uplodExpiration(@RequestBody List<Expiration> expirations) {
		dao.createExpiration(expirations);
	}
	
	@RequestMapping( path = "/expiration", method=RequestMethod.GET)
	public List<Expiration> listAllExpirations(){
		return dao.getExpirations();
	}
	
	
	@RequestMapping( path= "/expiration/update", method=RequestMethod.POST)
	public Expiration updateExpiration(@RequestBody Expiration expiration) {
		return dao.updateExpiration(expiration);
		
	}
	

	

}
