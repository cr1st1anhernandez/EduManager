/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EduManager.Utils;

import EduManager.Components.SuccessComponent;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import raven.toast.Notifications;

/**
 *
 * @author cristian
 */
public class SendEmail {

	Dotenv dotenv = Dotenv.load();
	private String emailFrom = dotenv.get("EMAIL");
	private String passwordFrom = dotenv.get("EMAIL_PASSWORD");
	private String emailTo = dotenv.get("EMAIL");
	private String subject;
	private String content;
	private String emailUser;
	private String userName;

	private Properties mProperties;
	private Session mSession;
	private MimeMessage mCorreo;

	public SendEmail() {
		mProperties = new Properties();
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void createEmail() {

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", emailFrom);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSession = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSession);
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");

		} catch (AddressException ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void sendEmail() {
		try {
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();

			SuccessComponent successComponent = new SuccessComponent();
			successComponent.setText("Correo Enviado");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
		} catch (NoSuchProviderException ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void sendEmailAsync() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			sendEmail();
			executor.shutdown();
		});
	}

}
