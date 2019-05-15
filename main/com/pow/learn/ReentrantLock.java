package main.com.pow.learn;

import java.util.concurrent.locks.Lock;

public class ReentrantLock {
    private static Lock lock = new java.util.concurrent.locks.ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
    }

    public static synchronized void method() throws InterruptedException {

        System.out.println("im method");
        Thread.sleep(1000);
        method();
    }
}
