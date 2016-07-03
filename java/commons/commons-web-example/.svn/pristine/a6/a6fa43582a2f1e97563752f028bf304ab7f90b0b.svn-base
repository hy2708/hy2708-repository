package org.hy.commons.web.example.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestHandler implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.err.println(request);
		Integer count = (Integer) request.getServletContext().getAttribute("count");
		if (count==null) {
			count =0;
		}
		request.getServletContext().setAttribute("count",count+1 );
		System.err.println("访问量是【" +
				(count+1)+"】");
	}

}
