package concurrency.ch3;

public class ReaderJob implements Runnable {

	private PrintQueue printQueue;

	public ReaderJob(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		printQueue.read();
	}

}
