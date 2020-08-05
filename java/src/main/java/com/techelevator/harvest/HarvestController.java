package com.techelevator.harvest;
import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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
	public void uploadHarvests(@RequestBody String path) throws FileNotFoundException {
		dao.createHarvests(path);
	}
	
}
