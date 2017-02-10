package concurrency.ch3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PrintQueue {
	private Semaphore semaphore;
	private boolean[] freePrinters;
	private Lock lockPrinters;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private long readCounter = 0;

	public PrintQueue(int printerCount) {
		semaphore = new Semaphore(printerCount);
		freePrinters = new boolean[printerCount];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public PrintQueue() {
	}
	
	public void write() {
		try {
			lock.writeLock().lock();
			
			try {
				System.out.println(Thread.currentThread().getName() + " start write");
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			readCounter++;
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public long read() {
		try {
			lock.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " start read");
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return readCounter;
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public void printJob (Object ducument) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			long duration = (long) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() + " ==== " + duration + " --- " + assignedPrinter);
			TimeUnit.SECONDS.sleep(5);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
