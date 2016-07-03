package org.hy.commons.lang.aop.proxy;

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
    Method getMethod();

    /**
     * <p>Returns the arguments at this join point.</p>
     */
    Object[] getArgs();

    /** Returns the signature at the join point.
     *
     * <code>getStaticPart().getSignature()</code> returns the same object
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
