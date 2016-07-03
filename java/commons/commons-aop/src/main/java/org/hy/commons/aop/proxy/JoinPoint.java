package org.hy.commons.aop.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;


public interface JoinPoint {

    String toString();

    /**
     * Returns an abbreviated string representation of the join point.
     */
    String toShortString();

    /**
     * Returns an extended string representation of the join point.
     */
    String toLongString();

    /**
     * <p> Returns the currently executing object.  This will always be
     * the same object as that matched by the <code>this</code> pointcut
     * designator.  Unless you specifically need this reflective access,
     * you should use the <code>this</code> pointcut designator to
     * get at this object for better static typing and performance.</p>
     *
     * <p> Returns null when there is no currently executing object available.
     * This includes all join points that occur in a static context.</p>
     */
    Object getThis();

    /**
     * <p> Returns the target object.  This will always be
     * the same object as that matched by the <code>target</code> pointcut
     * designator.  Unless you specifically need this reflective access,
     * you should use the <code>target</code> pointcut designator to
     * get at this object for better static typing and performance.</p>
     *
     * <p> Returns null when there is no target object.</p>

     */
    Object getTarget();
    
    /**
     * 
     * 
     * <ul>
     * <li>方法含义：原来的方法,的名称</li>
     * <li>方法作者：花宏宇</li>
     * <li>编写日期：2015-1-6；时间：下午3:27:32</li>
     * </ul>
     * <ul>
     * <b>修订编号：</b>
     * <li>修订日期：</li>
     * <li>修订作者：</li>
     * <li>修订原因：</li>
     * <li>修订内容：</li>
     * </ul>
     * @return
     */
    Method getMethod();

    /**
     * 
     * 
     * <ul>
     * <li>方法含义：向原来的方法，传递的参数</li>
     * <li>方法作者：花宏宇</li>
     * <li>编写日期：2015-1-6；时间：下午3:26:31</li>
     * </ul>
     * <ul>
     * <b>修订编号：</b>
     * <li>修订日期：</li>
     * <li>修订作者：</li>
     * <li>修订原因：</li>
     * <li>修订内容：</li>
     * </ul>
     * @return
     */
    Object[] getArgs();
    Object getReturnObject();
    public void setReturnObject(Object returnObject);

    /**
     * 
     * 
     * <ul>
     * <li>方法含义：原来的方法，的标签<br/>
     * Returns the signature at the join point.
     * <code>getStaticPart().getSignature()</code> returns the same object</li>
     * <li>方法作者：花宏宇</li>
     * <li>编写日期：2015-1-6；时间：下午3:28:42</li>
     * </ul>
     * <ul>
     * <b>修订编号：</b>
     * <li>修订日期：</li>
     * <li>修订作者：</li>
     * <li>修订原因：</li>
     * <li>修订内容：</li>
     * </ul>
     * @return
     */
    Signature getSignature();

    /** <p>Returns the source location corresponding to the join point.</p>
     *
     *  <p>If there is no source location available, returns null.</p>
     *
     *  <p>Returns the SourceLocation of the defining class for default constructors.</p>
     *
     *  <p> <code>getStaticPart().getSourceLocation()</code> returns the same object. </p>
     */
    SourceLocation getSourceLocation();

    /** Returns a String representing the kind of join point.  This
     *       String is guaranteed to be
     *       interned. <code>getStaticPart().getKind()</code> returns
     *       the same object.
     */
    String getKind();

}
