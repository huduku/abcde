package com.abcde.thread;


/**
 * 题目 ： 判断打印 one or two
 *
 * 1. 两个普通synchronized 方法，
 * 2. one中sleep 3秒
 * 3. 添加 普通的方法 getThree
 * 4. 注释掉getThree的线程，新增number2， 将number.getTwo改为number2.getTwo
 */
public class Test8Monitor {


    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                number.getTwo();
                number2.getTwo();
//                number.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }

    private static class Number {

        public synchronized static void getOne () {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        }

        public synchronized static void getTwo () {
            System.out.println("two");
        }

        public void getThree () {
            System.out.println("three");
        }
    }
}
