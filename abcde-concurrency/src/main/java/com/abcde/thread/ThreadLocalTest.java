package com.abcde.thread;


public class ThreadLocalTest {

    private static ThreadLocal local = new ThreadLocal();
    private static InheritableThreadLocal ilocal = new InheritableThreadLocal();

    public static void main(String[] args) {
        local.set("aaaaaaaaa");
        ilocal.set("bbbbbbbbb");
        Thread t = new MyThread();
        t.start();

    }

    static class MyThread extends Thread {
        @Override
        public void run(){
            System.out.println("local value : " + local.get() );
            ilocal.set("cccccccccccccc");
            local.set("dddddddddddddddd");
            MyThread2 thread2 = new MyThread2();
            thread2.start();
        }
    }


    static class MyThread2 extends MyThread {
        public void run(){
            System.out.println("local value : " + local.get() );
            System.out.println("ilocal value : " + ilocal.get());
        }
    }


}
