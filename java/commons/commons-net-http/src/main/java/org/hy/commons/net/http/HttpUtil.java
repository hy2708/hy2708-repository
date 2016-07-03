package org.hy.commons.net.http;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;




public class HttpUtil {
	public static void main(String[] args) {
		HttpBrowser browser = new HttpBrowser();

	    HttpRequest request = HttpRequest.get("www.facebook.com");
	    browser.sendRequest(request);

	    // request is sent and response is received

	    // process the page:
	    String page = browser.getPage();

	    // create new request
	    HttpRequest newRequest = HttpRequest.post(formAction);

	    browser.sendRequest(newRequest);
	}
	public static void main2(String[] args) {
		 HttpRequest httpRequest = HttpRequest.get("http://jodd.org");
		    HttpResponse response = httpRequest.send();

		    System.out.println(response);
		    
		    HttpRequest request = new HttpRequest();
		    request
		        .method("GET")
		        .protocol("http")
		        .host("srv")
		        .port(8080)
		        
		        .path("/api/jsonws/user/get-user-by-id");
	}

}
