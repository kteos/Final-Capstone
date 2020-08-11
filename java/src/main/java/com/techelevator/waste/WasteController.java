package com.techelevator.waste;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class WasteController {
	
	private WasteDao dao;
	
	public WasteController ( WasteDao dao ) {
		this.dao = dao;
	}
	
	
	
	@RequestMapping(path= "/waste/input", method = RequestMethod.POST)
	void insertWaste(@RequestBody Waste waste ) {
		dao.insertWaste(waste);
	}
		


}
