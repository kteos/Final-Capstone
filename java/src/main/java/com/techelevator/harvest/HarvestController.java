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
	private Path path;
	
	public HarvestController(HarvestDao dao, Path path) {
		this.dao = dao;
		this.path = path;
	}

	@RequestMapping(path = "/harvest/upload", method = RequestMethod.POST)
	public void uploadHarvests(@RequestBody String patha) throws FileNotFoundException {
		dao.createHarvests(path.getPath(), patha);
	}
	
}
