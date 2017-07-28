package com.abcde.thread;




public class TestVolatile {


    public static void main(String[] args) throws InterruptedException {

        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();

//        Thread.sleep(100);

        while (true) {
            if (demo.isFlag()) {
                System.out.println("------------------------");
                break;
            }
        }

    }

    private static class ThreadDemo implements Runnable {

        private  boolean flag = false;

        @Override
        public void run () {
            try {
                Thread.sleep(50);
            }catch (Exception e) {
                e.printStackTrace();
            }

            flag = true;
            System.out.println("flag = " + flag);
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}
