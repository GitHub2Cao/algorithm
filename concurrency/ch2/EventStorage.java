package concurrency.ch2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public EventStorage() {
		maxSize = 10;
		storage = new ArrayList<>();
	}
	
	public void set() {
		lock.unlock();
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
	
	public void get() {
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
