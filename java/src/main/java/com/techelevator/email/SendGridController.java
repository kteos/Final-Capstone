package com.techelevator.email;
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
public class SendGridController {
	private SendGridDao dao;
	
	public SendGridController(SendGridDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path="/send", method = RequestMethod.POST)
	public void sendEmail() {
		dao.sendEmail();
	}
}
