package com.abcde.thread;


import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {

    public static void main(String[] args) {
        Runnable atomicDemo = new AtomicDemo();


        for (int i = 0 ; i < 10 ; i++) {
            Thread t = new Thread(atomicDemo);
            t.start();
        }
    }



    private static class AtomicDemo implements Runnable {

//        private volatile int i = 0;
        private AtomicInteger i = new AtomicInteger(0);

        @Override
        public void run() {
            int t  = i.getAndIncrement();
            System.out.println(t);
        }

//        public void increase () {
//            i++;
//        }
    }
}
