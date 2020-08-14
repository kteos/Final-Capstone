package com.techelevator.crops;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class CropsController {
	private CropsDao dao;
	
	public CropsController(CropsDao dao) {
		this.dao = dao;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/crops/upload", method = RequestMethod.POST)
	public void uploadCrops(@RequestBody List<Crops> crops , Principal user )  {
		dao.createCrops( crops , user.getName() );
	}
	
	@RequestMapping( path = "/crops", method = RequestMethod.GET)
	public List<Crops> listAllCrops( Principal user ){
		return dao.getAllCrops( user.getName() );
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/crops/update", method = RequestMethod.POST)
	public void updateHarvest(@RequestBody Crops crop , Principal user) {
		dao.updateCrops(crop , user.getName());
	}
}
