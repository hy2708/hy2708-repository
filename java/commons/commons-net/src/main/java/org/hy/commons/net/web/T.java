package org.hy.commons.net.web;

import org.eclipse.jetty.server.Server;
import org.hy.server.jetty8.HelloServerlet;
import org.hy.server.jetty8.JettyUtil;

public class T {
	public static void main(String[] args) {
		Server server = JettyUtil.getServer();
		JettyUtil.addServlet("/myApp2", DemoServlet.class, "/hello");
		JettyUtil.startServer();

	}

}
