package com.techelevator.loss;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class LossController {
	private LossDao dao;
	
	public LossController ( LossDao dao ) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/loss/input" , method= RequestMethod.POST)
	void insertLossInfo(@RequestBody Loss loss) {
		dao.insertLossInfo(loss);
	}

}
