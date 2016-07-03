package com.hy.designpatern.struct.responsibilitychain._01;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	private List<Filter> filters = new ArrayList<Filter>();
	
	public FilterChain addFilter(Filter f){
		filters.add(f); 
		return this;
	}
	@Override
	public void doFilter(Request request) {
		for(Filter f:filters){
			f.doFilter(request); 
		}
		
	}
	
}
