package com.abcde.thread;




public class TestThreadPool {

    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        new Thread(demo).start();
        new Thread(demo).start();
        new Thread(demo).start();
    }

    private static class ThreadPoolDemo implements Runnable {

        private int i = 0;

        @Override
        public void run() {
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + " --- > " + ++i);
            }
        }
    }
}
