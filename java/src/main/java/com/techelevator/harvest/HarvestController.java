package com.techelevator.harvest;
import java.security.Principal;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class HarvestController {

	private HarvestDao dao;
	

	
	public HarvestController(HarvestDao dao) {
		this.dao = dao;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/harvest/upload", method = RequestMethod.POST)
	public void uploadHarvests(  @RequestBody Harvest[] harvest , Principal user )  {
		dao.createHarvests( harvest, user.getName() );
	}
	
	@RequestMapping( path = "/harvest", method = RequestMethod.GET)
	public List<Harvest> listAllCrops(Principal user){
		return dao.cropNames(user.getName());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/harvest/update", method = RequestMethod.POST)
	public Harvest updateHarvest(@RequestBody Harvest harvest , Principal user) {
		return dao.updateHarvest(harvest, user.getName());
	}
	
}
