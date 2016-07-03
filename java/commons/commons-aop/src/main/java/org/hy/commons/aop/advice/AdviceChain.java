package org.hy.commons.aop.advice;

public interface AdviceChain {

    public Object proceed() throws Throwable;

    public Object proceed(Object[] args) throws Throwable;

}
