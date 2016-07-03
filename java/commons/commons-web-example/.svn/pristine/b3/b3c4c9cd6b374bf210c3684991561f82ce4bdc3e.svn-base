package org.hy.commons.web.example.listener.session;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionHandler2 implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		
		ServletContext context =session.getServletContext();
		List<HttpSession> list = (List<HttpSession>) context.getAttribute("sessions");
		if (list==null) {
			list = new LinkedList<HttpSession>();
			context.setAttribute("sessions", list);
		}
		list.add(session);
		System.err.println("00000000在线人数+1======"+list.size());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.err.println("在线人数-1");
		// TODO Auto-generated method stub
		
	}

}
