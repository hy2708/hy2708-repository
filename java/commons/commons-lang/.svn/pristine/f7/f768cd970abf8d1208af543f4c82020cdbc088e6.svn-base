package org.hy.commons.lang.thread.threadlocal.example01;

public class ThreadLocalNumOne {
    // 使用线程变量ThreadLocalNum
    private ThreadLocalVarNum threadLocalNum = new ThreadLocalVarNum();

    public void addOne() {
        threadLocalNum.getNextSeq();
        System.out.println("after invoke addOne method,value is "
                + threadLocalNum.getValue());
    }

    public void showValue() {
        System.out.println("ThreadLocalNumOne print threadLocal value is:"
                + threadLocalNum.getValue());
    }

}     