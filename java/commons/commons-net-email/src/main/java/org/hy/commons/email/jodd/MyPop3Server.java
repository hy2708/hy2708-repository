package org.hy.commons.email.jodd;

import javax.mail.Authenticator;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import jodd.mail.MailException;
import jodd.mail.Pop3Server;
import jodd.mail.ReceiveMailSession;

public class MyPop3Server extends Pop3Server {
	
	
	@Override
	public ReceiveMailSession createSession()
    {
        Session session = Session.getInstance(sessionProperties, authenticator);
        Store store;
        try
        {
            store = getStore(session);
        }
        catch(NoSuchProviderException nspex)
        {
            throw new MailException("Unable to create POP3 session", nspex);
        }
        return new MyReceiveMailSession(session, store);
    }
	

	public MyPop3Server(String host, Authenticator authenticator) {
		super(host, authenticator);
		// TODO Auto-generated constructor stub
	}

	public MyPop3Server(String host, int port, Authenticator authenticator) {
		super(host, port, authenticator);
		// TODO Auto-generated constructor stub
	}

	public MyPop3Server(String host, int port, String username, String password) {
		super(host, port, username, password);
		// TODO Auto-generated constructor stub
	}

	public MyPop3Server(String host, int port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	public MyPop3Server(String host) {
		super(host);
		// TODO Auto-generated constructor stub
	}

}
