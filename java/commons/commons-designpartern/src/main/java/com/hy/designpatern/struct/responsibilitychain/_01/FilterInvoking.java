package com.hy.designpatern.struct.responsibilitychain._01;

public class FilterInvoking {
		
	public static void main(String[] args){
		Filter f1= new  FirstFilter();
		Filter f2= new  SecondFilter();
		FilterChain fc= new FilterChain();
		fc.addFilter(f1)
		.addFilter(f2);
		Request request = new Request();
		request.setRequestStr("me123");
		f1.doFilter(request);
		f2.doFilter(request);
		fc.doFilter(request);
	}
}
