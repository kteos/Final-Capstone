package com.techelevator.waste;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin

public class WasteController {
	
	private WasteDao dao;
	
	public WasteController ( WasteDao dao ) {
		this.dao = dao;
	}
	
	
	
	@RequestMapping(path= "/waste/input", method = RequestMethod.POST)
	void insertWaste(@RequestBody Waste waste , Principal user ) {
		dao.insertWaste(waste , user.getName());
	}
		


}
