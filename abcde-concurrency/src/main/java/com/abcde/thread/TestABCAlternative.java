package com.abcde.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABCAlternative {


    public static void main(String[] args) {
        AlterDemo ad = new AlterDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 20 ; i++) {
                    ad.loopA(i);
                }
            }
        } , "A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 20 ; i++) {
                    ad.loopB(i);
                }
            }
        } , "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 20 ; i++) {
                    ad.loopC(i);
                }
            }
        } , "C").start();
    }


    private static class AlterDemo {

        private int number = 1;

        private Lock lock = new ReentrantLock();
        private Condition ca = lock.newCondition();
        private Condition cb = lock.newCondition();
        private Condition cc = lock.newCondition();

        private void loopA (int totalLoop) {
            lock.lock();

            try {
                while (number != 1) {
                    try {
                        ca.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
                }

                number = 2;
                cb.signal();
            } finally {
                lock.unlock();
            }
        }

        private void loopB (int totalLoop) {
            lock.lock();

            try {
                while (number != 2) {
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 15; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
                }

                number = 3;
                cc.signal();
            } finally {
                lock.unlock();
            }
        }

        private void loopC (int totalLoop) {
            lock.lock();

            try {
                while (number != 3) {
                    try {
                        cc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
                }
                System.out.println("------------------------");
                number = 1;
                ca.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
