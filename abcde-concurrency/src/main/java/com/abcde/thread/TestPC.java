package com.abcde.thread;



public class TestPC {


    public static void main(String[] args) {
        Movie m = new Movie();

        Player p = new Player(m);
        Wathcer w = new Wathcer(m);

        new Thread(p).start();
        new Thread(w).start();
    }

    /**
     * 一个场景 , 共同的资源
     */
    private static class Movie {

        private volatile boolean flag = true;

        private String pic;


        public synchronized void play (String pic ) {
            //生产者等待
            while (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //开始生产
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //生产完毕
            this.pic = pic;
            System.out.println("生产了 ： " + pic);
            //通知消费
            this.notify();
            //生产者停下
            this.flag = false;
        }

        public synchronized void watch () {
            //消费者等待
            while (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //开始消费
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //消费完毕
            System.out.println("消费了 ： " + pic);
            //通知生产
            this.notifyAll();
            //消费者停止
            this.flag = true;
        }
    }

    private static class Player implements Runnable {

        private Movie m;

        public Player (Movie m) {
            super();
            this.m = m;
        }

        @Override
        public void run() {
            for (int i = 0 ; i < 20 ; i++) {
                if (i%2 == 0) {
                    m.play("左青龙");
                }else {
                    m.play("右白虎");
                }
            }
        }
    }

    private static class Wathcer implements Runnable {

        private Movie m;

        public Wathcer(Movie m) {
            this.m = m;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                m.watch();
            }
        }
    }
}
