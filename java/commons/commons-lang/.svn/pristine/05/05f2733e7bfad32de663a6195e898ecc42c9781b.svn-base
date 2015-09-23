package org.hy.commons.lang.thread.threadlocal.example01;


public class TreadLocalNumCrossObjectTest {

    /**
     * 测试线程变量是可以穿越类的，他应该是跟线程相关的
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocalNumOne one = new ThreadLocalNumOne();
        ThreadLocalNumTwo two = new ThreadLocalNumTwo();
        one.addOne();
        two.addOne();
        one.showValue();
        two.showValue();
    }

}    