package org.hy.commons.lang.aop.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

public class JoinPointImpl implements JoinPoint {

	//Object _this;
	Object target;
	Method method;
	Object[] args;
	

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

}
