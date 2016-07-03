package org.hy.commons.email.jodd;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import jodd.mail.MailException;
import jodd.mail.ReceiveMailSession;
import jodd.mail.SimpleAuthenticator;

/*
 * 获取邮件最好用IMAP
 */
public class MyImapServer {
	
    public MyImapServer() {
		super();
		this.sessionProperties = System.getProperties();
		sessionProperties.setProperty("mail.store.protocol", "imaps");
		//sessionProperties.setProperty("mail.store.protocol", "imap"); 
		//sessionProperties.setProperty("mail.imap.host", host); 
		sessionProperties.setProperty("mail.imap.port", "143");
		this.host=null;
		this.authenticator = null;
	}

	protected final Authenticator authenticator;
    protected final Properties sessionProperties;
    protected final String host;

    
	public MyImapServer(String host, Authenticator authenticator) {
		this.sessionProperties = System.getProperties();
		sessionProperties.setProperty("mail.store.protocol", "imaps");
		//sessionProperties.setProperty("mail.store.protocol", "imap"); 
		//sessionProperties.setProperty("mail.imap.host", host); 
		sessionProperties.setProperty("mail.imap.port", "143");
		this.host=host;
		this.authenticator = authenticator;
	}
	
	public ReceiveMailSession createSession()
    {
//        Session session = Session.getInstance(sessionProperties, authenticator);
        Session session = Session.getInstance(sessionProperties, null);
        Store store =null;
        try
        {
            // store = getStore(session);
        	store = session.getStore("imaps");
//        	store.connect("imap.googlemail.com","hy5178@gmail.com", "hhy8611hhyy");
        	
        }
        catch(NoSuchProviderException nspex)
        {
            throw new MailException("Unable to create POP3 session", nspex);
        } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new MyReceiveMailSession(session, store);
    }
}
