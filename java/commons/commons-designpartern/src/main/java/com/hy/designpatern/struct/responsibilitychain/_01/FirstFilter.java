package com.hy.designpatern.struct.responsibilitychain._01;

public class FirstFilter implements Filter{

	@Override
	public void doFilter(Request request) {
		// TODO Auto-generated method stub
		System.out.println("----FirstFileter----");
		request.setRequestStr(request.getRequestStr()+"----FirstFileter----");
		System.out.println(request.getRequestStr());
	}
	
}
