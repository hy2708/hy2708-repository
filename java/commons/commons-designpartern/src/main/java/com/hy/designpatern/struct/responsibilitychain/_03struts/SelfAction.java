package com.hy.designpatern.struct.responsibilitychain._03struts;
public class SelfAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("execute SelfAction");
		return SUCCESS;
	}
}