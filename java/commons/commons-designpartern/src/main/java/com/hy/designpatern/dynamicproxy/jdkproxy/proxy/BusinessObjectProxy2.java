package com.hy.designpatern.dynamicproxy.jdkproxy.proxy;

import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessInterface;
import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessObject;

public class BusinessObjectProxy2 implements BusinessInterface {
	
	
	Object bo;
	public BusinessObjectProxy2(Object bo) {
		super();
		this.bo = bo;
	}
	@Override
	public void getMoney() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doBusiness() {
		System.out.println(this.getClass().getSimpleName()+" : do Business ..........");

	}

}
