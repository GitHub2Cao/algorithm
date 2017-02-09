package concurrency.ch2;

import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {
	private PricesInfo pricesInfo;
	
	public Writer(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Writer : Attempt to modify the prices.");
			pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.println("Writer: Prices have been modified.");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
