package br.com.fabricadevs.ativos.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

//	@Autowired
//	private JavaMailSender javaMailSender;

	public void sendEmail(File file, String filename, String messageString, String subject, String email, String emails, 
			String name, Boolean addCc) throws Exception {

		String from = "ADSROCK <rafael@adsrock.com.br>";

		final String username = "rafael@adsrock.com.br";
		final String password = "SUA_SENHA";


		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.adsrock.com.br");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			if (email != null) {

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse((name == null ? email : name) + " <" + email + ">"));

			} 
			
			if (emails != null) {
				
				List<String> emailList = Arrays.asList(emails.split(";"));
				
				for(String allEmails : emailList) {
					
					message.addRecipients(Message.RecipientType.CC, InternetAddress.parse((name == null ? allEmails : name) + " <" + allEmails + ">"));
				};
				
			}
			
			message.setSubject(subject);

			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setContent(messageString, "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			if(file != null) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}


	public static String stringToHtmlSymbol(String value) {

		if (value.contains("??")) {
			value = value.replace("??", "&Aacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&aacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Acirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&acirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Agrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&agrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Atilde;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&atilde;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Eacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&eacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Ecirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&ecirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Egrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&egrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Iacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&iacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Igrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&igrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Oacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&oacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Ocirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&ocirc;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Ograve;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&ograve;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Otilde;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&otilde;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Uacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&uacute;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Ugrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&ugrave;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&Ccedil;");
		}
		if (value.contains("??")) {
			value = value.replace("??", "&ccedil;");
		}

		return value;
	}

}
