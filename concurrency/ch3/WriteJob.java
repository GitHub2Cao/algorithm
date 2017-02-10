package concurrency.ch3;

public class WriteJob implements Runnable {
	private PrintQueue printQueue;

	public WriteJob(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		printQueue.write();
	}
}
