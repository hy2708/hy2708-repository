package org.hy.commons.aop.jodd.proxetta;

import jodd.proxetta.ClassInfo;
import jodd.proxetta.asm.MethodSignatureVisitor;

public class MethodInfoImpl extends MethodSignatureVisitor{

	public MethodInfoImpl(String methodName, int access, String classname,
			String description, String signature, ClassInfo targetClassInfo) {
		super(methodName, access, classname, description, signature, targetClassInfo);
		
	}

}
