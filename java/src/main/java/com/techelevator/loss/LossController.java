package com.techelevator.loss;

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

public class LossController {
	private LossDao dao;
	
	public LossController ( LossDao dao ) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/loss/input" , method= RequestMethod.POST)
	void insertLossInfo(@RequestBody Loss loss , Principal user) {
		dao.insertLossInfo(loss , user.getName());
	}

}
