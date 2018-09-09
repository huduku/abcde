package com.abcde.thread;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

	public long timeTasks( int nThreads , Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i =0 ; i < nThreads ; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						//子线程t等待startGate.countDown到0,才能继续执行下边的task.run()等流程
						startGate.await();
						try {
							task.run();
						}finally {
							//子线程中将endGate.countDown到0
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			t.start();
		}

		long start = System.nanoTime();
		System.out.println("主线程-"+1);
		//主线程中将startGate.countDown()到0
		startGate.countDown();
//		Thread.sleep(100);
		System.out.println("主线程-"+2);
		//主线程等待endGate.countDown到0才能执行下边的打印,计算操作用时等操作
		endGate.await();
		System.out.println("主线程-"+3);
		long end = System.nanoTime();
		System.out.println(end - start);
		return end - start;
	}


	public static void main(String[] args) throws InterruptedException {
		new TestHarness().timeTasks(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("子线程-" + Thread.currentThread().getName());
			}
		});
	}

}
