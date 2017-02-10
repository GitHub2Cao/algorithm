package concurrency.ch2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		this.buffer = new LinkedList<>();
		this.lock = new ReentrantLock();
		this.lines = lock.newCondition();
		this.space = lock.newCondition();
		this.pendingLines = true;
	}
	
	

}
