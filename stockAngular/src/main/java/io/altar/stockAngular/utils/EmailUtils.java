package io.altar.stockAngular.utils;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import io.altar.stockAngular.models.DTOS.UserDTO;

@RequestScoped
public class EmailUtils {
	private static boolean active = false;

	public static void sendNewUser(UserDTO userDTO) throws IOException {
		if (!active) {
			return;
		}
		Mail mail = new Mail();
		Email fromEmail = new Email();
	    fromEmail.setName(System.getProperty("SGFromName"));
	    fromEmail.setEmail(System.getProperty("SGFromEmail"));
	    mail.setFrom(fromEmail);

	    mail.setTemplateId(System.getProperty("SGTemplateId"));

	    Personalization personalization = new Personalization();
	    personalization.addDynamicTemplateData("user" , userDTO);
	    personalization.addTo(new Email(userDTO.getEmail()));
	    mail.addPersonalization(personalization);
		
		try {
			SendGrid sg = new SendGrid(System.getProperty("SGKey"));
			Request request = new Request();
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
