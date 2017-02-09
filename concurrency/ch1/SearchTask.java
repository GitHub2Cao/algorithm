package concurrency.ch1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
	private Result result;
	
	public SearchTask(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		try {
			doTask();
			result.setName(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			System.out.println("interrupted ==== " + Thread.currentThread().getName());
			return;
		}
	}
	
	private void doTask() throws InterruptedException {
		Random random = new Random(new Date().getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.println(Thread.currentThread().getName() + " --- " + value);
		TimeUnit.SECONDS.sleep(value);
	}
	
	
	

}
