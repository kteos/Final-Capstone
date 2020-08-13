package com.techelevator.Harvestinfo;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.internal.Path;

@RestController
@CrossOrigin

public class HarvestInfoController {
	
	
	private HarvestInfoDao dao;
	
	public HarvestInfoController( HarvestInfoDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path= "/harvestinfo/input", method = RequestMethod.POST)
	public void harvestInfoinsert(@RequestBody HarvestInfo harvestInfo, Principal user) {
		dao.insertHarvestInfo(harvestInfo , user.getName());
	}

}
