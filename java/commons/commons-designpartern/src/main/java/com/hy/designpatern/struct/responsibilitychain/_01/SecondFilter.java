package com.hy.designpatern.struct.responsibilitychain._01;

public class SecondFilter implements Filter{

	@Override
	public void doFilter(Request request) {
		// TODO Auto-generated method stub
		System.out.println("----SecondFileter----");
		request.setRequestStr(request.getRequestStr()+"----SecondFileter----");
		System.out.println(request.getRequestStr());
	}
	
}
