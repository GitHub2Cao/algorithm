package concurrency.ch1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name) {
		this.counter = 0;
		this.name = name;
		this.stats = new ArrayList<>();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + this.counter+5);
		counter++;
		this.stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
		return t;
	}
	
	public String getStats() {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while (it.hasNext()) {
			buffer.append(it.next());
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
	
	
}
