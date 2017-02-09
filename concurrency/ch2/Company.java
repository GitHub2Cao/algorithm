package concurrency.ch2;

public class Company implements Runnable {
	private Account account;
	
	public Company(Account accout) {
		this.account = accout;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.addAmount(1000);
		}
	}

}
