package com.hy.designpatern.struct.responsibilitychain._02filter;

public class FirstFilter implements Filter{

	@Override
	public void doFilter(Request request, Response response,FilterChain filterChain) {
		// TODO Auto-generated method stub
		System.out.println("----1---FirstFilter is running");
		request.setRequestStr(request.getRequestStr()+"----FirstFileter----");
		//System.out.println(request.getRequestStr());
		
		
		response.setResponseStr(response.getResponseStr()+"----FirstFileter----");
		
		
		filterChain.doFilter(request, response);
	
		//System.out.println("request is running");
		//System.out.println(response.getResponseStr());
		System.out.println("----1back---FirstFilter is running");
	}

	
	
}
