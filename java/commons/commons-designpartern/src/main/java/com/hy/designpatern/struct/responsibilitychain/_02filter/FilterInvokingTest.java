package com.hy.designpatern.struct.responsibilitychain._02filter;

public class FilterInvokingTest {
		
	public static void main(String[] args){
		Filter f1= new  FirstFilter();
		Filter f2= new  SecondFilter();
		FilterChain fc= new FilterChain();
		fc.addFilter(f1)
		.addFilter(f2);
		Request request = new Request();
		request.setRequestStr("me123"); 

		Response response = new Response();
		response.setResponseStr("ponse123");
		/*
		 1\FilterChain run method named doFilter(request, response);
		 2\FilterChain 从List<Filter>取出第一个Filter，
		 3、Filter 执行 filters.get(i).doFilter(request, response, this);方法
		 4\1、Filter内部一些操作
		 4\2、Filter内部，再调用FilterChain.doFilter(request, response);
		 4\3、Filter内部一些操作
		 5、再次，执行2\,FilterChain，从List<Filter>取出下一个Filter
		 */
		fc.doFilter(request, response);
	}
}
