package org.hy.commons.web.example.listener.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionHandler implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.err.println(session);
		System.err.println("在线人数+1");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.err.println("在线人数-1");
		// TODO Auto-generated method stub
		
	}

}
