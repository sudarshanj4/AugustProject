package com.example.sudarshan_projectspringboot.lld.threads.concurrency3.mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(2);
        Count count=new Count();
        Lock lock = new ReentrantLock();
        Adder add = new Adder(count,lock);
        Substractor sub = new Substractor(count,lock);

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(sub);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("The number is :"+count.num);
        es.shutdown();
    }
}
