package concurrency.ch2;

import java.util.concurrent.TimeUnit;

public class Account {
	private double balance;
	
	public  void addAmount(double amount) {
		synchronized (this) {
			doAdd(amount);
		}
	}

	private void doAdd(double amount) {
		double tmep = balance;
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmep += amount;
		balance = tmep;
	} 

	public  void subtractAmount(double amount) {
		synchronized (this) {
			doSubtract(amount);
		}
	}

	private void doSubtract(double amount) {
		double tmp = balance;
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
