package com.example.sudarshan_projectspringboot.lld.threads.oopsCalable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.random.RandomGenerator;

public class Randomnogenerator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        System.out.println("First thread started");
        int n=random.nextInt();
//        Thread.sleep(1000*8);
        System.out.println(n+" The thread is :"+Thread.currentThread().getName());
        return n;
    }
}
