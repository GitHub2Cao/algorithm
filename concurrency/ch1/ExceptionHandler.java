package concurrency.ch1;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * @author cgm
 *
 */
public class ExceptionHandler implements  UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		e.printStackTrace(System.out);
		System.out.println(t.getState());
		System.out.println(t.getStackTrace());
		
	}
}
