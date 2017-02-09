package concurrency.ch1;

import java.util.Date;

public class UnsafeTask implements Runnable {
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		@Override
		protected Date initialValue() {
	        return new Date();
	    }
	};

	@Override
	public void run() {
		startDate.get();
	}
	
	

}
