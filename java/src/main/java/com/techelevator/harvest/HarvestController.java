package com.techelevator.harvest;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HarvestController {

	private HarvestDao dao;
	

	
	public HarvestController(HarvestDao dao) {
		this.dao = dao;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/harvest/upload", method = RequestMethod.POST)
	public void uploadHarvests(@RequestBody Harvest[] harvest )  {
		dao.createHarvests( harvest );
	}
	
	@RequestMapping( path = "/harvest", method = RequestMethod.GET)
	public List<Harvest> listAllCrops(){
		return dao.cropNames();
	}
	
}
