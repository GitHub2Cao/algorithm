package concurrency.ch3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		int rows = 100000;
		int numbers = 1000;
		int search = 5;
		int participants = 5;
		int lines_participants = 20000;
		
		MatrixMock mock = new MatrixMock(rows, numbers, search);
		Results results = new Results(rows);
		
		Grouper grouper = new Grouper(results);
		
		CyclicBarrier barrier = new CyclicBarrier(participants, grouper);
		Searcher[] searchers = new Searcher[participants];
		
		for (int i = 0; i < participants; i++) {
			searchers[i] = new Searcher(i * lines_participants, i * lines_participants + lines_participants, mock, results, 5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		
//		Videoconference videoconference = new Videoconference(10);
//		
//		Thread videoconferenceThread = new Thread(videoconference);
//		
//		videoconferenceThread.start();
//		
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			Participant p = new Participant(videoconference, "p" + i);
//			Thread participantThread = new Thread(p);
//			participantThread.start();
//		}
		
		
		
		
		
//		PrintQueue printQueue = new PrintQueue();
//		
//		Thread writerThread = new Thread(new WriteJob(printQueue));
//		writerThread.start();
//		
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Thread[] readerThreads = new Thread[5];
//		for (int i = 0; i < 5; i++) {
//			readerThreads[i] = new Thread(new ReaderJob(printQueue), "thead-" + i);
//		}
//		
//		for (Thread thread : readerThreads) {
//			thread.start();
//		}
		
//		for (Thread thread : readerThreads) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		try {
//			writerThread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		//System.out.println("main end");
	}

}
