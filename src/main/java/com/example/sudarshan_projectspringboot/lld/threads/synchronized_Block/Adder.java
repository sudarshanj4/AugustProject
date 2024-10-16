package com.example.sudarshan_projectspringboot.lld.threads.synchronized_Block;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Count count;
    Lock lock;
    public Adder(Count count) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            synchronized (count) {
                count.num++;
            }
        }
        System.out.println("Adder executed");
    }
}
