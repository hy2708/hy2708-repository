package org.hy.commons.lang.thread.threadlocal.example01;

public class ThreadLocalNumTwo {
    // 使用线程变量ThreadLocalNum
    private ThreadLocalVarNum threadLocalNum = new ThreadLocalVarNum();

    public void addOne() {
        threadLocalNum.getNextSeq();
        System.out.println("after invoke addOne method,value is "
                + threadLocalNum.getValue());
    }
    
    public void addTwo() {
        for (int i = 0; i < 2; i++) {
            threadLocalNum.getNextSeq();
        }
        System.out.println("after invoke addTwo method,value is "
                + threadLocalNum.getValue());
    }

    public void showValue() {
        System.out.println("ThreadLocalNumTwo print threadLocal value is:"
                + threadLocalNum.getValue());
    }
} 