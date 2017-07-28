package com.abcde.thread;


public class TestCompareAndSwap {

    public static void main(String[] args) {

        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0 ; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    boolean flag = cas.compareAndSet (expectedValue,(int)(Math.random() * 1001));
                    System.out.println(flag);
                }
            }).start();
        }

    }


    private static class CompareAndSwap {

        private int value;

        public synchronized int compareAndSwap (int expectedValue, int newValue) {
            int oldValue = value;
            if (oldValue == expectedValue) {
                this.value = newValue;
                System.out.println(this.value);
            }
            return oldValue;
        }

        public boolean compareAndSet ( int expectedValue ,  int newValue) {
            return expectedValue == compareAndSwap(expectedValue,newValue);
        }


        public int get() {
            return value;
        }
    }
}
