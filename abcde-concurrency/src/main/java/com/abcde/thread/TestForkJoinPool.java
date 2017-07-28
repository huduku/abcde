package com.abcde.thread;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {


    public static void main(String[] args) {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalucate(0 , 100000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());

        start = Instant.now();
        test();
        end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

    private static void test () {
        long sum = 0L;
        for (long i = 1 ; i <= 100000000L ; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static class ForkJoinSumCalucate extends RecursiveTask<Long> {


        private static final long serialVersionUID = 1;

        private long start;
        private long end;

        private static final Long THRESHOLE = 10000L;

        public ForkJoinSumCalucate(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long length = end - start;
            if (length <= THRESHOLE) {
                long sum = 0L;

                for (long i = start; i <= end ; i++) {
                    sum += i;
                }

                return sum;
            }else {
                long middle = (start + end) / 2;

                ForkJoinSumCalucate left = new ForkJoinSumCalucate(start,middle);
                left.fork(); //进行拆分 ， 同时压入线程队列

                ForkJoinSumCalucate right = new ForkJoinSumCalucate(middle + 1,end);
                right.fork();

                return left.join() + right.join();
            }

        }


    }

}


