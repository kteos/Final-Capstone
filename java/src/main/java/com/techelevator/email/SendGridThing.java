package com.techelevator.email;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import com.sendgrid.helpers.mail.*;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;

import java.io.IOException;

public class SendGridThing {
// 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 sendgrid's api key	

    public static void main(String[] args) throws IOException {
        Email from = new Email("leozverres@gmail.com");
        String subject = "FLEXXXXXXXIN";
        Email to = new Email("zacharykolker93@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        System.out.println("API Key is " + System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
          request.setMethod(Method.POST);
          request.setEndpoint("mail/send");
          request.setBody(mail.build());
          Response response = sg.api(request);
          System.out.println(response.getStatusCode());
          System.out.println(response.getBody());
          System.out.println(response.getHeaders());
        } catch (IOException ex) {
        	
          throw ex;
        }
      }
    

}

