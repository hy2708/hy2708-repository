package org.hy.commons.web.example.listener.session;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hy.commons.web.servlet.BaseHttpServlet;

public class SessionCreationServlet extends BaseHttpServlet {

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		HttpSession session = request.getSession();
		System.out.println("urlsession " + session.getId());
		
	}

	
	public void showSessions(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		ServletContext context = request.getServletContext();
		List<HttpSession> list = (List<HttpSession>) context.getAttribute("sessions");
		for (HttpSession session : list) {
			System.err.println(session.getAttribute("user")
					+"  "+
					session.getCreationTime()+"  "+
					session.getLastAccessedTime());
		}
		System.err.println("777777777"+list);
	}
	

}
