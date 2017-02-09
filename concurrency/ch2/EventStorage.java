package concurrency.ch2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage() {
		maxSize = 10;
		storage = new ArrayList<>();
	}
	
	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		storage.add(new Date());
		System.out.println("name --- " + Thread.currentThread().getName() + "set size ==== " + storage.size());
		notifyAll();
	}
	
	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("get size ==== " + storage.size() + " ---- " + storage.remove(0));
		notifyAll();
	}

}
