package concurrency.ch1;

/**
 * This class generates prime numbers until is interrumped
 */
public class PrimeGenerator implements Runnable {

	/**
	 * Central method of the class
	 */
	@Override
	public void run() {
		long number = 1L;
		
		

		// This bucle never ends... until is interrupted
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
				System.out.println(Thread.currentThread().isInterrupted());
			}

			// When is interrupted, write a message and ends
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted\n");
				continue;
			}
			number++;
		}
	}

	/**
	 * Method that calculate if a number is prime or not
	 * 
	 * @param number
	 *            : The number
	 * @return A boolean value. True if the number is prime, false if not.
	 */
	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

}
