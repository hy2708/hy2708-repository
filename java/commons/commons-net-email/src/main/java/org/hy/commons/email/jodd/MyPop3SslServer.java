package org.hy.commons.email.jodd;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import jodd.mail.MailException;
import jodd.mail.Pop3SslServer;
import jodd.mail.ReceiveMailSession;

public class MyPop3SslServer extends Pop3SslServer{
	
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
	

	public MyPop3SslServer(String host, int port, String username,
			String password) {
		super(host, port, username, password);
		// TODO Auto-generated constructor stub
	}

	public MyPop3SslServer(String host, String username, String password) {
		super(host, username, password);
		// TODO Auto-generated constructor stub
	}

}
