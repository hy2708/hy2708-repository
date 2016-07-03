package org.hy.commons.aop.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

public class JoinPointImpl implements JoinPoint {

	/**
	 * 原来的对象
	 */
	Object target;
	/*
	 * 原来的对象的方法
	 */
	Method method;
	/**
	 * 原来的对象的方法的参数
	 */
	Object[] args;
	
	/*
	 * 原来的对象的方法的返回值
	 */
	Object returnObject;
	

	public JoinPointImpl(Object target, Method method, Object[] args) {
		super();
		this.target = target;
		this.method = method;
		this.args = args;
	}

	@Override
	public String toShortString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toLongString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getThis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTarget() {
		// TODO Auto-generated method stub
		return this.target;
	}

	
	public Method getMethod() {
		return method;
	}

	@Override
	public Object[] getArgs() {
		return this.args;
	}

	@Override
	public Signature getSignature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SourceLocation getSourceLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getReturnObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	
}
