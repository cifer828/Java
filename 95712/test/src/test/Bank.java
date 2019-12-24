package test;

import java.util.concurrent.TimeUnit;

public class Bank {
	public static void main(String[] args) {
		BankAccount2 b = new BankAccount2(30);			//shared resource 
		Thread one = new Thread (new BankingThread(b));
		Thread two = new Thread (new BankingThread(b));
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}

	public static String spacer(String name) {	//method to format the console output
		String spacer;
		if (Thread.currentThread().getName().equals("Ryan")) 
			spacer = String.format("%" + 50 + "s", " "); //shift Ryan to right column in output
		else spacer = "";
		return spacer;
	}
}

class BankingThread implements Runnable {
	BankAccount2 b;
	BankingThread(BankAccount2 b) {
		this.b = b;
	}
	@Override
	public void run() { 
		String name = Thread.currentThread().getName(); //who is running
		String spacer = Bank.spacer(name); //for output formatting. 
		for (int i = 0 ; i < 3; i++) {
			b.withdraw(10, i);
			if (b.balance < 0) System.out.println(spacer + name + "*** Account overdrawn");
		}
	}
}


class BankAccount2 {
	static double balance;
	BankAccount2(double balance) { this.balance = balance; }  // constructor

	public void withdraw(double amount, int i) {
		String name = Thread.currentThread().getName(); //who is withdrawing
		String spacer = Bank.spacer(name); //for output formatting. Shifts Ryan to right column.
		if (balance >= amount) {
			try {
				System.out.println(spacer + name + i + " sees balance = $" + balance + " and sleeps");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(spacer + name + i + " wakes up, withdraws $" + amount);
			} catch (InterruptedException e) { System.out.println(e.getMessage()); } 
			balance -= amount;
		} else {
			System.out.println(spacer + name + " sees: Not enough money!");
		}
	}
}
