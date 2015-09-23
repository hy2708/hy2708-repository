package org.hy.commons.web.example.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.example.entity.User;
import org.hy.server.jetty8.JettyUtil;



public class LoginServlet extends HttpServlet {
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addFilter(LoginFilter.class, "/login/authority/*", JettyUtil.getDispatcherTypes("request"));
		JettyUtil.getWebAppContext().addServlet(LoginServlet.class, "/login"+JettyUtil.HELLO);
//		JettyUtil.getWebAppContext().addServlet(TestRequestServlet.class, "/testRequestServlet");
		JettyUtil.startServer();
		
//		Thread.sleep(1000);

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("用户退出");
		//删除整个session
		request.getSession().invalidate();
		Cookie c = new Cookie("autoLogin", "ddd");
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);
//		request.getSession().removeAttribute("name");
		
		request.getSession().setAttribute("exit",true);
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String u = req.getParameter("username");
		String p = req.getParameter("password");
		System.err.println("username "+u);
		System.err.println("password "+p);
		if(u!=null){
			Cookie cookie = new Cookie("user", "hasLogin");
			cookie.setMaxAge(60*60);
			resp.addCookie(cookie);
			request.getSession().setAttribute("user", userName);
		}
		req.setAttribute("username",u);
		req.getRequestDispatcher("/login/ok.jsp").forward(req, resp);
	}

	public boolean isLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session==null) return false;
		User u = (User)session.getAttribute("loginUser");
		if(u==null) return false;
		return true;
	}
}
