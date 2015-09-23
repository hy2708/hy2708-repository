package org.hy.commons.dao.core.util;

import java.util.List;


//@Component("page")
/**
 * Page<T>为可重用组件，以后可以重构，用于链式编程
 * 对象set方法的调用顺序为
 * 		setPageSize(int pageSize)；此方法可省略
 * 		setTotalRecords(int totalRecords)；
 * 		setList(List<T> list)
 * 可用来与Pager Taglib结合是用
 */
public class Page<T> {
	
	private final int firstPage =1;
	private int lastPage;
	private List<T> datas;
	
	private int nextPageNo;
	private int offset;
	private int pageNo = 1;
	private int pageSize = 25;
	private int previousPageNo;
	private int totalPages;
	private Long totalRecords;
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public int getFirstPage() {
		return firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	
	public int getNextPageNo() {
		return nextPageNo;
	}
	
	
	public int getOffset() {
		return offset;
	}
	
	public int getOffset(int pageNo,int pageSize) {
		offset = (pageNo-1)*pageSize;
		return offset;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getPreviousPageNo() {
		return previousPageNo;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	/*public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}*/
	
	public void setNextPageNo(int nextPageNo) {
		if(pageNo>= totalPages) {nextPageNo = totalPages;
		}else{
			this.nextPageNo = nextPageNo;
		}
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	/**
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		if(pageNo> totalPages) {pageNo = totalPages;
		}else if(pageNo<1) {pageNo = 1;
		}else{
			this.pageNo = pageNo;
		}
		//this.pageNo = pageNo;
	}
	
	
	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setPreviousPageNo(int previousPageNo) {
		if(previousPageNo<=1) {previousPageNo = 1;
		}else{
			this.previousPageNo = previousPageNo;
		}
		
	}
	/**
	 * 
	 * @param totalRecords
	 */
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
		totalPages = (int) ((totalRecords + pageSize -1)/pageSize);
		lastPage = totalPages;
		if(pageNo<=1) {previousPageNo = 1;
		}else{
			previousPageNo = pageNo -1;
		}
		if(pageNo>= totalPages) {nextPageNo = totalPages;
		}else{
			nextPageNo = pageNo +1;
		}
		
	}
}
