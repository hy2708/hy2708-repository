package com.hy.designpatern.dynamicproxy.jdkproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;


import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessInterface;

public class BusinessObjectProxy3 implements  InvocationHandler{
	
	
	Object bo;
	public BusinessObjectProxy3(Object bo) {
		super();
		this.bo = bo;
	}
	
	@Override
	public java.lang.Object invoke(java.lang.Object proxy, Method method,
			java.lang.Object[] args) throws Throwable {
		System.out.println("before process");
		Object reObject= method.invoke(proxy, args);
		System.out.println("after process");
		return reObject;
	}
	

}
