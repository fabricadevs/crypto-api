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

		if (value.contains("Á")) {
			value = value.replace("Á", "&Aacute;");
		}
		if (value.contains("á")) {
			value = value.replace("á", "&aacute;");
		}
		if (value.contains("Â")) {
			value = value.replace("Â", "&Acirc;");
		}
		if (value.contains("â")) {
			value = value.replace("â", "&acirc;");
		}
		if (value.contains("À")) {
			value = value.replace("À", "&Agrave;");
		}
		if (value.contains("à")) {
			value = value.replace("à", "&agrave;");
		}
		if (value.contains("Ã")) {
			value = value.replace("Ã", "&Atilde;");
		}
		if (value.contains("ã")) {
			value = value.replace("ã", "&atilde;");
		}
		if (value.contains("É")) {
			value = value.replace("É", "&Eacute;");
		}
		if (value.contains("é")) {
			value = value.replace("é", "&eacute;");
		}
		if (value.contains("Ê")) {
			value = value.replace("Ê", "&Ecirc;");
		}
		if (value.contains("ê")) {
			value = value.replace("ê", "&ecirc;");
		}
		if (value.contains("È")) {
			value = value.replace("È", "&Egrave;");
		}
		if (value.contains("è")) {
			value = value.replace("è", "&egrave;");
		}
		if (value.contains("Í")) {
			value = value.replace("Í", "&Iacute;");
		}
		if (value.contains("í")) {
			value = value.replace("í", "&iacute;");
		}
		if (value.contains("Ì")) {
			value = value.replace("Ì", "&Igrave;");
		}
		if (value.contains("ì")) {
			value = value.replace("ì", "&igrave;");
		}
		if (value.contains("Ó")) {
			value = value.replace("Ó", "&Oacute;");
		}
		if (value.contains("ó")) {
			value = value.replace("ó", "&oacute;");
		}
		if (value.contains("Ô")) {
			value = value.replace("Ô", "&Ocirc;");
		}
		if (value.contains("ô")) {
			value = value.replace("ô", "&ocirc;");
		}
		if (value.contains("Ò")) {
			value = value.replace("Ò", "&Ograve;");
		}
		if (value.contains("ò")) {
			value = value.replace("ò", "&ograve;");
		}
		if (value.contains("Õ")) {
			value = value.replace("Õ", "&Otilde;");
		}
		if (value.contains("õ")) {
			value = value.replace("õ", "&otilde;");
		}
		if (value.contains("Ú")) {
			value = value.replace("Ú", "&Uacute;");
		}
		if (value.contains("ú")) {
			value = value.replace("ú", "&uacute;");
		}
		if (value.contains("Ù")) {
			value = value.replace("Ù", "&Ugrave;");
		}
		if (value.contains("ù")) {
			value = value.replace("ù", "&ugrave;");
		}
		if (value.contains("Ç")) {
			value = value.replace("Ç", "&Ccedil;");
		}
		if (value.contains("ç")) {
			value = value.replace("ç", "&ccedil;");
		}

		return value;
	}

}
