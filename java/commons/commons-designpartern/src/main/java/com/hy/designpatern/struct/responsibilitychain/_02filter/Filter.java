package com.hy.designpatern.struct.responsibilitychain._02filter;

public interface Filter {
	public void doFilter(Request request, Response response,FilterChain filterChain) ;
}
