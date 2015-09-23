package com.hy.designpatern.struct.responsibilitychain._02filter;

public class SecondFilter implements Filter{

	@Override
	public void doFilter(Request request, Response response,FilterChain filterChain) {
		// TODO Auto-generated method stub
		System.out.println("----2---SecondFilter is running");
		request.setRequestStr(request.getRequestStr()+"----SecondFileter----");
		//System.out.println(request.getRequestStr());
		
		response.setResponseStr(response.getResponseStr()+"----SecondFileter----");
		
		filterChain.doFilter(request, response);

		//System.out.println("request is running");

		//System.out.println(response.getResponseStr());
		System.out.println("----2back------SecondFilter is running");
	}
	
}
