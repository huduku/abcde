package com.abcde.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {

//	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
//		@Override
//		public ProductInfo call() throws Exception {
//			return loadProductInfo();
//		}
//	});
//
//	private final Thread thread = new Thread(future);
//
//	public void start() {
//		thread.start();
//	}
//
//	public ProductInfo get() {
//		try {
//			return future.get();
//		} catch (ExecutionException e) {
//			Throwable cause = e.getCause();
//			if (cause instanceof DataLodException ) {
//				throw (DataLoadException)cause;
//			}else {
//				throw launderThrowable(cause);
//			}
//		}
//	}
}
