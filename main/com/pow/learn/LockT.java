package main.com.pow.learn;

import java.util.concurrent.locks.Lock;
public class LockT {

    public static void main(String[] args) {

        Lock lock = new java.util.concurrent.locks.ReentrantLock();
        lock.lock();
        new Thread(new MyTask()).start();
        new Thread(new MyTask()).start();

    }

     static class MyTask implements Runnable{

        @Override
        public void run() {
            synchronized ("1") {
                System.out.println("订单提交中  " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("订单提交完成  " + Thread.currentThread().getName());
            }
        }
    }
}
