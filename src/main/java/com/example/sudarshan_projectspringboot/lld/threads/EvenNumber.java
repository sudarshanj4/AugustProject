package com.example.sudarshan_projectspringboot.lld.threads;

public class EvenNumber implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println("This is even number : ="+i+" the thread is :"+Thread.currentThread().getName());
            }
        }
    }
}
