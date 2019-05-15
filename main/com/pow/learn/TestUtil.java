package main.com.pow.learn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestUtil {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) throws InterruptedException {
     Set<Integer> s1 = new HashSet<>();
     Set<Integer> s2 = new HashSet<>();

     s1.add(1);
     s1.add(2);
     s1.add(3);
     s2.addAll(s1);
     s1.remove(1);
        System.out.println(s2.size());
        System.out.println(s2.size());

    }
    public static void method(Thread thread){
        String name = thread.getName();
        lock.readLock().lock();
        for(int i=0;i<5;i++){
            System.out.println(name+"--在读取数据");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.readLock().unlock();
        lock.writeLock().lock(); //写锁
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"--写完成");
        lock.readLock().unlock();
    }
}
