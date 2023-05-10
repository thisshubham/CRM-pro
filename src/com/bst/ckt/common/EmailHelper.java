/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     EmailHelper.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class Sending Email to user 
 * 
 * Amendment History (in chronological sequence): OCT 4, 2017
 * 
 **********************************************************************
 */
package com.bst.ckt.common;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.bst.ckt.common.EmailHelper;
import com.bst.ckt.exception.EmailSendFailedException;

/**
 * <p>
 * <code>EmailHelper</code> class is designed to send email to user based on
 * passing messages to its parameter.
 * </p>
 * 
 * @author Deepak VIshwakarma
 * @version 1.0
 */
public class EmailHelper {

	/*
	 * Creating Logger object, logger object mapped with EmailHelper class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(EmailHelper.class);

	/**
	 * <p>
	 * Method <code>sendEmail(final String emailToAddress,
	 * final String emailSubject, final String emailBodyText)</code> will send
	 * the email to user.
	 * </p>
	 * 
	 * @param emailToAddress
	 *            Sting receiver email address
	 * @param emailSubject
	 *            Subject line which will append to email as subject.
	 * @param emailBodyText
	 *            Actual Message which will sent to user including user details.
	 * @throws EmailSendFailedException
	 *             Exception will thrown when email sending failed.
	 */
	public static void sendEmail(final String emailToAddress,
			final String emailSubject, final String emailBodyText)
			throws EmailSendFailedException {

		Properties properties = new Properties();
		try {

			// CurrentClassName.class.getResourceAsStream("foo.properties");
			InputStream inputStream = EmailHelper.class
					.getResourceAsStream("EmailConfiguration.properties");
			// load a properties file
			properties.load(inputStream);
		} catch (Exception fileNotFoundException) {
			logger.error("EmailConfiguration.properties file not found ;");
		}

		// make sure you put your correct gmail address and password
		final String username = properties.getProperty("support.email.sender");
		// make sure you put your gmail address
		final String password = properties
				.getProperty("support.email.password");
		// We will put some properties for smtp configurations
		Properties props = new Properties();

		// do not change - start
		props.put("mail.smtp.host", properties.getProperty("mail.smtp.host"));

		// props.put("mail.debug", "true");
		props.put("mail.smtp.auth", properties.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable",
				properties.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.smtp.EnableSSL.enable",
				properties.getProperty("mail.smtp.EnableSSL.enable"));

		props.setProperty("mail.smtp.socketFactory.class",
				properties.getProperty("mail.smtp.socketFactory.class"));
		props.setProperty("mail.smtp.socketFactory.fallback",
				properties.getProperty("mail.smtp.socketFactory.fallback"));
		props.setProperty("mail.smtp.port",
				properties.getProperty("mail.smtp.port"));
		props.setProperty("mail.smtp.socketFactory.port",
				properties.getProperty("mail.smtp.socketFactory.port"));
		// do not change - end

		// Setting session when user email authentication success
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			// Create Mime message for email
			Message message = new MimeMessage(session);
			// Setting the from 'email address'
			message.setFrom(new InternetAddress(username));
			// Setting 'to email address'
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailToAddress));
			// Setting email subject line
			message.setSubject(emailSubject);
			// Setting email message
			message.setText(emailBodyText);
			// Sending the email
			Transport.send(message);

		} catch (MessagingException messagingException) {
			logger.error("Failed to send email.", messagingException);
			throw new EmailSendFailedException("Failed to send email.",
					messagingException);
		}

	}

}
