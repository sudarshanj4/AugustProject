package com.example.sudarshan_projectspringboot.lld.threads;

public class Main {
    public static void main(String[] args) {
        OddNumber odd = new OddNumber();
        EvenNumber even = new EvenNumber();

        Thread oddThread = new Thread(odd);
        Thread evenThread = new Thread(even);

        oddThread.start();
        evenThread.start();
    }
}
