package com.techelevator.email;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import io.jsonwebtoken.io.IOException;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.*;

@Component
public class JdbcSendGridDao implements SendGridDao{

	public void sendEmail(String user) {
		HttpResponse<String> response = Unirest.post("https://api.sendgrid.com/v3/mail/send")
				  .header("authorization", "Bearer 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")
				  .header("content-type", "application/json")
				  .body("{\"personalizations\":[{\"to\":[{\"email\":\"" +
						  user + 
						  "\",\"name\":\"User\"}],\"subject\":\"Daily Notification Farm Assist\"}],\"content\":[{\"type\":\"text/plain\",\"value\":\"" +
						  "You've signed up for daily notifications with Farm Assist. You harvested tomatos 2 days ago and haven't sold them yet. They are going to go bad soon. Hey, Field A25 should have corn ready for harvest soon." + 
						  "\"}],\"from\":{\"email\":\"noreplyfarmassist@gmail.com\",\"name\":\"Farm Assist\"}}")
				  .asString();
	}
	
	/*
	 * Hey, you need to seed the following crops today: carrots, beets, lettuce. 
	 * Hey, your tomato and pepper transplants should be ready for field 1 today.
		Hey, Field 1 should have peppers ready for harvest soon. 
		You harvested tomatoes 3 days ago and haven't sold them yet. They are going to go bad soon.
	 */
	

	
}
