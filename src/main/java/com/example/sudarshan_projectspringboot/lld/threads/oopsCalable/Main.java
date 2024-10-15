package com.example.sudarshan_projectspringboot.lld.threads.oopsCalable;

import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.concurrent.*;

public class Main  {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Randomnogenerator rng = new Randomnogenerator();
        Future<Integer> fi = es.submit(rng);
        System.out.println("new service start");
        int randomnumber=fi.get(5, TimeUnit.SECONDS);
        System.out.println("random number is "+randomnumber+ "The Thread is "+Thread.currentThread().getName());
        es.shutdown();
    }
}
