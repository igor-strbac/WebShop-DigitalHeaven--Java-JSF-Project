package webshop.email;

import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name = "sendmailMB", eager = true)
@ViewScoped
public class SendEmail implements Serializable {
    
   public void sendEmail() {
      // Recipient's email ID needs to be mentioned.
      String to = "strbac80@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "prodaja@digitalheaven.co";
      final String username = "prodaja@digitalheaven.co";//change accordingly
      final String password = "Prodaja";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "mail.digitalheaven.co";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
//      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "26");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject("Testing Subject");
	
	   // Now set the actual message
	   message.setText("Hello, this is sample for to check send " +
		"email using JavaMailAPI ");

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}

