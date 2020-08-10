package com.techelevator.crops;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class CropsController {
	private CropsDao dao;
	
	public CropsController(CropsDao dao) {
		this.dao = dao;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/crops/upload", method = RequestMethod.POST)
	public void uploadCrops(@RequestBody List<Crops> crops )  {
		dao.createCrops( crops );
	}
	
	@RequestMapping( path = "/crops", method = RequestMethod.GET)
	public List<Crops> listAllCrops(){
		return dao.getAllCrops();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/crops/update", method = RequestMethod.POST)
	public void updateHarvest(@RequestBody Crops crop) {
		dao.updateCrops(crop);
	}
}
