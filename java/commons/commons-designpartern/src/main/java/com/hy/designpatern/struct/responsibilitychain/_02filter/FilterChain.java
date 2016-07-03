package com.hy.designpatern.struct.responsibilitychain._02filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FilterChain {
	
	private List<Filter> filters = new ArrayList<Filter>();
	/*
	Iterator<Filter> iterator = filters.iterator(); 
	 先得到迭代器，之后又对List添加元素，所以，遍历的时候，迭代器报错
	应该改成Iterator<Filter> iterator = null;
	 
	 Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.AbstractList$Itr.checkForComodification(AbstractList.java:372)
	at java.util.AbstractList$Itr.next(AbstractList.java:343)
	at com.hy.designpatern.struct.responsibilitychain._02filter.FilterChain.doFilter(FilterChain.java:48)
	at com.hy.designpatern.struct.responsibilitychain._02filter.FilterInvokingTest.main(FilterInvokingTest.java:25)

	 */
//	Iterator<Filter> iterator = filters.iterator(); 
	Iterator<Filter> iterator = null;
	//Iterator<AroundAdvice> aroundAdvices = null;
	
	int i=-1;
	int index=0;
	public FilterChain addFilter(Filter f){
		filters.add(f); 
		return this;
	}
	
	public void doFilter2(Request request, Response response, FilterChain chain) {  
        if (index == filters.size())  
            return;  
        Filter f = filters.get(index);  
        index++;  
        f.doFilter(request, response, chain);  
    }  
	
	
	public void doFilterxxx(Request request, Response response) {
		if(++i<filters.size()){
			//System.out.println(i);
			//i++;
			filters.get(i).doFilter(request, response, this);
		}else {
			System.out.println("HttpServlet is running request.getRequestStr()"+request.getRequestStr());;

		}
		/*for(Filter f:filters){
			f.doFilter(request, response,this);
		}*/
	}
	
	public void doFilter(Request request, Response response) {

		if (iterator==null)	 {
			iterator = filters.iterator();
		}
		if ( iterator.hasNext()) {
			Filter type =  iterator.next();
			type.doFilter(request, response, this);
			
		}else  {
			System.out.println("eee"+request.getRequestStr());;
		}
		
		/*for(Filter f:filters){
			f.doFilter(request, response,this);
		}*/
		//System.out.println("run request.getRequestStr()"+request.getRequestStr());;

	}
}
