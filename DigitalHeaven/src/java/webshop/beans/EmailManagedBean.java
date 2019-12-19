package webshop.beans;

import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@ManagedBean(name = "sendMail", eager = true)
@ViewScoped
public class EmailManagedBean implements Serializable {

    @ManagedProperty(value = "#{loginMB}")
    private LoginManagedBean loginBean;
    

    public void sendEmail(String listaproizvoda) {

        String to = "strbac80@gmail.com";

        String from = "prodaja@digitalheaven.co";
        final String username = "prodaja@digitalheaven.co";
        final String password = "Prodaja";

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
            message.setSubject("Nova prodaja na DigitalHeaven.co");

            // Now set the actual message
            message.setText("Registrovana je sledeca prodaja: Ime i prezime:"
                    + loginBean.getLoggedInUser().getIme() + " " + loginBean.getLoggedInUser().getPrezime() + "; Broj telefona: "
                    + loginBean.getLoggedInUser().getTelefon() + "; Email korisnika: " + loginBean.getLoggedInUser().getEmail() + "; Kupljeno: "
                    + listaproizvoda);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginManagedBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginManagedBean loginBean) {
        this.loginBean = loginBean;
    }

}
