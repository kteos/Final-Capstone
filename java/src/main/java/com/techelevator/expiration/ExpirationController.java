package com.techelevator.expiration;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ExpirationController {
	
	
	private ExpirationDao dao;
	
	public ExpirationController ( ExpirationDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping( path= "/expiration/upload", method= RequestMethod.POST)
	public void uplodExpiration(@RequestBody List<Expiration> expirations , Principal user) {
		dao.createExpiration(expirations, user.getName());
	}
	
	@RequestMapping( path = "/expiration", method=RequestMethod.GET)
	public List<Expiration> listAllExpirations(Principal user){
		return dao.getExpirations(user.getName());
	}
	
	
	@RequestMapping( path= "/expiration/update", method=RequestMethod.POST)
	public Expiration updateExpiration(@RequestBody Expiration expiration, Principal user) {
		return dao.updateExpiration(expiration, user.getName());
		
	}
	

	

}
