package com.example.sudarshan_projectspringboot.lld.threads;

public class OddNumber implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println("This is odd number :="+i+" the thread is :"+Thread.currentThread().getName());
            }
        }
    }
}
