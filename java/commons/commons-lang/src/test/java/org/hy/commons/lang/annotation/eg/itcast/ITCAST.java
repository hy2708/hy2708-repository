package org.hy.commons.lang.annotation.eg.itcast;

@Name("传智播客")
public class ITCAST {
	@Description("java学科")
	public void java(){
		System.out.println("很牛");
	}
	
	@Description("net学科")
	public void net(){
		System.out.println("也很牛");
	}
}
