package concurrency.ch1;

/**
 * Main class of the example
 */
public class Main {

	/**
	 * Main method of the example
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThreadFactory factory = new MyThreadFactory("tttt");
		Task task = new Task();
		
		Thread thread;
		System.out.println("Starting the Threads\n");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		
		System.out.println(factory.getStats());
		
		
		
		
	}
}
