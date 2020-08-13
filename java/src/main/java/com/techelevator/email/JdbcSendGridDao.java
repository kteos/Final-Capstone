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

	public void sendEmail() {
		HttpResponse<String> response = Unirest.post("https://api.sendgrid.com/v3/mail/send")
				  .header("authorization", "Bearer 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")
				  .header("content-type", "application/json")
				  .body("{\"personalizations\":[{\"to\":[{\"email\":\"zacharykolker93@gmail.com\",\"name\":\"John Doe\"}],\"subject\":\"Hello, World!\"}],\"content\":[{\"type\":\"text/plain\",\"value\":\"Heya! please work lmao\"}],\"from\":{\"email\":\"leozverres@gmail.com\",\"name\":\"Sam Smith\"}}")
				  .asString();
	}
	
	
//	public String jsonBuilder() {
////		String[] person = {"to","subject"};
////		Map<String,String> to = new HashMap<String,String>();
////		to.put("email", "zacharykolker93@gmail.com");
////		to.put("name","zachary");
////		String[] subject = {""};
////		try {
////		String jsonString = new JSONObject()
////				.put("personalizations",person).toString();
////		return jsonString;
////		}catch(Exception e) {
////			System.out.println(e.getMessage());
////		}
////		return null;
////		final JsonNodeFactory factory = JsonNodeFactory.instance;
////		final ObjectNode node = factory.objectNode();
////		final ObjectNode child = factory.objectNode();
////		
//	}
	   public void sendGrid() throws IOException, java.io.IOException {

	       Email from = new Email("zacharykolker93@gmail.com");
	       Email to = new Email("leozverres@gmail.com"); // use your own email address here

	       String subject = "Sending with Twilio SendGrid is Fun";
	       Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");

	       Mail mail = new Mail(from, subject, to, content);

	       SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	       Request request = new Request();

	       request.setMethod(Method.POST);
	       request.setEndpoint("mail/send");
	       request.setBody(mail.build());

	       Response response = sg.api(request);

	       System.out.println(response.getStatusCode());
	       System.out.println(response.getHeaders());
	       System.out.println(response.getBody());
	   }
}
