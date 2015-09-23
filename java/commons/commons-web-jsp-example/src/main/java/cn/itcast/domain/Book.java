package cn.itcast.domain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.server.jetty8.JettyUtil;

public class Book {
	public static void main(String[] args) {
		Server server = JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		WebAppContext webAppContext =JettyUtil.getWebAppContext();
		JettyUtil.startServer();
	}
	
	private String id;
	private String title;
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Book() {
	}
	public Book(String id, String title, String price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	

}
