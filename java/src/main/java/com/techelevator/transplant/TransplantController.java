package com.techelevator.transplant;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class TransplantController {

	private TransplantDao dao;

	public TransplantController(TransplantDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/transplant/upload", method = RequestMethod.POST)
	public void uploadTransplants(@RequestBody Transplant[] transplant , Principal user )  {
		dao.createTransplants(transplant , user.getName());
	}
	
	@RequestMapping(path= "/transplant" , method = RequestMethod.GET)
	List<Transplant> getListOfTransplants(Principal user){
		return dao.listTransplant(user.getName());
	}
	
	@RequestMapping(path="/transplant/update", method=RequestMethod.POST)
	public Transplant updateTransplant(@RequestBody Transplant transplant, Principal user)  {
		return dao.updateTransplant(transplant, user.getName() );
	}
	
}
