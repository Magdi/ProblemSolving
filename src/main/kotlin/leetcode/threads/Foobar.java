package leetcode.threads;

import java.util.concurrent.atomic.AtomicBoolean;

class FooBar {
    private int n;
    private AtomicBoolean mSwitch = new AtomicBoolean(true);

    public FooBar(int n) {
        this.n = n;
    }

    synchronized public  void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!mSwitch.get()) wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            mSwitch.set(false);
            notify();
        }
    }

    synchronized public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (mSwitch.get()) wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            mSwitch.set(true);
            notify();
        }
    }
}
