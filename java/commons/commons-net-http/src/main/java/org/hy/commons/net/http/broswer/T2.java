package org.hy.commons.net.http.broswer;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

//import org.hy.server.jetty8.JettyUtil;

public class T2 {
	public static void main(String[] args) {
		String string ="https://cn-monitor.macromill.com/airs/exec/monitorLoginAction.do";
		String string2 = "http://cn-monitor.macromill.com/monitor/";
		HttpBrowser browser = new HttpBrowser();
		String name ="userId";
		String password ="password";
		HttpRequest request = HttpRequest.post(string2)
				//.query(name, "hy2708@gmail.com")
				//.query(password, "hhy8611hhy")
				//.queryString("userId=hy2708@gmail.com&password=hhy8611hhy&=%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9")
				;
		browser.sendRequest(request);
		HttpResponse response = browser.getHttpResponse();
		System.out.println(response.charset("utf8"));
		String body = response.bodyText();
		String string3 =response.statusPhrase();
		System.err.println(body);
		String namq ="TPL_username_1";
		

	}

}
