package com.techelevator.transplant;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class TransplantController {

	private TransplantDao dao;

	public TransplantController(TransplantDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/transplant/upload", method = RequestMethod.POST)
	public void uploadTransplants(@RequestBody Transplant[] transplant )  {
		dao.createTransplants(transplant);
	}
	
	@RequestMapping(path= "/transplant" , method = RequestMethod.GET)
	List<Transplant> getListOfTransplants(){
		return dao.listTransplant();
	}
	
	
}
