package org.hy.commons.net.http.broswer;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import org.hy.server.jetty8.JettyUtil;

public class T {
	public static void main(String[] args) {
		String string ="https://login.taobao.com/member/login.jhtml";
		HttpBrowser browser = new HttpBrowser();
		String name ="TPL_username";
		String password ="TPL_password";
		HttpRequest request = HttpRequest.post(string)
				.query(name, "h2674y")
				.query(password, "hhy8611hhy")
				;
		browser.sendRequest(request);
		HttpResponse response = browser.getHttpResponse();
		String body = response.bodyText();
		System.err.println(body);
		String namq ="TPL_username_1";

	}

}
