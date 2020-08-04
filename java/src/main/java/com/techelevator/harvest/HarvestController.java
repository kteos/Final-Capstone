package com.techelevator.harvest;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarvestController {

	private HarvestDao dao;
	
	
	public HarvestController(HarvestDao dao) {
		this.dao = dao;
		
	}

	@RequestMapping(path = "/harvest/upload", method = RequestMethod.POST)
	public void uploadHarvests(@RequestBody List<Harvest> harvest )  {
		dao.createHarvests( harvest );
	}
	
}
