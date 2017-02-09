package concurrency.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InterruptBeforeSleep {
	public static void main(String[] args) {
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("Running task");
				System.out.println(Thread.currentThread().getState());
				double dummy = 0.11111;
				for (double i = 2.0; i < 100000000.0; i++) {
					dummy *= (i / (i - 1));
				}
				System.out.println("Result is: " + dummy);
				System.out.println("About to sleep");
				
				int j = 1 / 0;
				
				try {
					System.out.println(Thread.currentThread().getState());
					System.out.println(Thread.currentThread().isInterrupted());
					//Thread.sleep(TimeUnit.SECONDS.toMillis(10));
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					System.out.println("I'm interrupted");
					Thread.currentThread().interrupted();
					System.out.println("I'm interrupted? " + Thread.currentThread().isInterrupted());
				}
				System.out.println(Thread.currentThread().getState());
			}
		};

		Thread t = new Thread(task);
		System.out.println(t.getState());
		t.setUncaughtExceptionHandler(new ExceptionHandler());
		t.start();
		System.out.println(t.getState());
		
		//t.interrupt();
		
		System.out.println("Main interrupted the task thread");
		System.out.println(t.getState());
	}
}
