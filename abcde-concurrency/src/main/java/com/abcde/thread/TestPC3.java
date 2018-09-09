package com.abcde.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestPC3 {


    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Producer p2 = new Producer(clerk);
        Consumer c2 = new Consumer(clerk);


        new Thread(p1 ,"生产者A").start();
        new Thread(c1 , "消费者B").start();

        new Thread(p2 ,"生产者C").start();
        new Thread(c2 , "消费者D").start();
    }

    private static class  Clerk {

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        private int product = 0 ;

        //进货
        public void getProduct () {
            lock.lock();
            try {
                while (product >= 1) {
                    System.out.println("产品已满！");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + ++product);
                condition.signalAll();
            } finally {
                lock.unlock();
            }


        }

        //卖货
        public void sale () {
            lock.lock();
            try {
                while (product <= 0) {
                    System.out.println("缺货");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + --product);
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    private static class Producer implements Runnable{
        private Clerk clerk ;

        public Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.getProduct();
            }
        }
    }

    private static class Consumer implements Runnable {

        private Clerk clerk;

        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sale();
            }
        }
    }

}
