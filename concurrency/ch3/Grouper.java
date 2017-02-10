package concurrency.ch3;

public class Grouper implements Runnable {
	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}

	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("grouper : processing results .... ");
		int data[] = results.getData();
		for (int i : data) {
			finalResult += i;
		}
		System.out.println("Grouper : total result : " + finalResult);
	}
}
