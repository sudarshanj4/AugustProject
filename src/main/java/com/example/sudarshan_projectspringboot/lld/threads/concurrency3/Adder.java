package com.example.sudarshan_projectspringboot.lld.threads.concurrency3;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Count count;
    Lock lock;
    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            lock.lock();
            count.num++;
            lock.unlock();
        }
        System.out.println("Adder executed");
    }
}
