package com.threadjdk5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Hello";
			}
		});
		System.out.println("Wait for the result:");
		System.out.println(future.get());

	}
}
