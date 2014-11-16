package com.testproject;

/* Using javamail - Access the GMAIL account and getting the last email from amazon.in

Author: Simon Nicholas */

import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import org.testng.annotations.Test;

public class GmailInbox {

	public static void main(String[] args) {
		GmailInbox gmail = new GmailInbox();
		gmail.read();
	}
	@Test
	public void read() {
		Properties props = new Properties();
		try {
			//File path of mail.properties
			props.load(new FileInputStream((System.getProperty("user.dir")+"\\src\\main\\java\\mail.properties")));
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect(props.getProperty("mail.smtp.host"), props.getProperty("userID"), props.getProperty("PWD"));
				

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			int messageCount = inbox.getMessageCount();

			System.out.println("Total Messages:- " + messageCount);

			Message[] messages = inbox.getMessages();
			System.out.println("Last Mail received from Amazon.in");
			
			// Simple Logic for getting last mail from Amazon.in
				 
			for (int i = messageCount; i > 0; i--) {
				
				if (messages[i-1].getSubject().equals("simon wants you to see this item at Amazon.in")) {
					System.out.println("Mail Subject:- " + messages[i-1].getSubject());
					System.out.println("Mail Time Stamp:- " + messages[i-1].getReceivedDate());
					 break;
				}
			} 	
			
			inbox.close(true);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

	