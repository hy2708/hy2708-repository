package org.hy.commons.lang.aop.proxy;



public interface ProceedingJoinPoint extends JoinPoint ,AdviceChain {

    /**
     * The joinpoint needs to know about its closure so that proceed can delegate to closure.run()
     * <p/>
     * This internal method should not be called directly, and won't be visible to the end-user when
     * packed in a jar (synthetic method)
     *
     * @param arc
     */
    //void set$AroundClosure(AroundClosure arc);

    /**
     * Proceed with the next advice or target method invocation
     *
     * @return
     * @throws Throwable
     */
    public Object proceed() throws Throwable;

    /**
     * Proceed with the next advice or target method invocation
     * <p/>
     * <p>Unlike code style, proceed(..) in annotation style places different requirements on the 
     * parameters passed to it.  The proceed(..) call takes, in this order:
     * <ul>
     * <li> If 'this()' was used in the pointcut for binding, it must be passed first in proceed(..).
     * <li> If 'target()' was used in the pointcut for binding, it must be passed next in proceed(..) - 
     * it will be the first argument to proceed(..) if this() was not used for binding.
     * <li> Finally come all the arguments expected at the join point, in the order they are supplied 
     * at the join point. Effectively the advice signature is ignored - it doesn't matter 
     * if a subset of arguments were bound or the ordering was changed in the advice signature, 
     * the proceed(..) calls takes all of them in the right order for the join point. 
     * </ul>
     * <p>Since proceed(..) in this case takes an Object array, AspectJ cannot do as much 
     * compile time checking as it can for code style. If the rules above aren't obeyed 
     * then it will unfortunately manifest as a runtime error. 
     * </p>
     *
     * @param args
     * @return
     * @throws Throwable
     */
    public Object proceed(Object[] args) throws Throwable;

}
