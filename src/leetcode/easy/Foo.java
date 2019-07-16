package leetcode.easy;

import java.util.concurrent.CountDownLatch;

/**
 * author：jutao
 * time：2019/7/16
 * description：1114. 按序打印
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class Foo {
    private CountDownLatch latch1;
    private CountDownLatch latch2;

    public Foo()  {
        latch1=new CountDownLatch(1);
        latch2=new CountDownLatch(2);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        latch1.countDown();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        printSecond.run();
        latch2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {

        latch2.await();
        printThird.run();
    }
}
