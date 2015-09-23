package org.hy.commons.lang.thread.threadlocal.example01;

/**
* 这个类的主要作用是取得下一个序列号，但是是通过ThreadLocal实现的，是线程的局部变量，所以是线程安全的
*
* @author Administrator
*
*/
public class ThreadLocalVarNum {
    // 这个很重要，ThreadLocal应该属于类，而不是对象,ThreadLocal实例通常是类中的私有静态字段
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>();

    public Integer getNextSeq() {
        if (seqNum.get() == null) {
            seqNum.set(Integer.valueOf(0));
            return Integer.valueOf(0);
        } else {
            Integer num = seqNum.get() + 1;
            seqNum.set(num);
            return num;
        }

    }

    public Integer getValue() {
        return seqNum.get();
    }

}     