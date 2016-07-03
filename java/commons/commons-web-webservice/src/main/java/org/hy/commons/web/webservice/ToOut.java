package org.hy.commons.web.webservice;

import javax.jws.WebService;


@WebService
public class ToOut {
	
	public String say(String req) {
		System.out.println("I have got a req");
		return "hello "+req;
	}

}
