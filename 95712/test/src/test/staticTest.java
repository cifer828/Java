package test;

class SavingsAccount extends BankAccount {
	static float transactionFee = 0.4f;
}

class BankAccount {
	static float transactionFee = 0.2f;
}

public class staticTest {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		SavingsAccount savingsAccount = new SavingsAccount();

		System.out.println("BankAccount fee: " + BankAccount.transactionFee);
		System.out.println("SavingsAccount fee: " + SavingsAccount.transactionFee);

		SavingsAccount.transactionFee = 0.2f; // using object to change class variable
		System.out.println("SavingsAccount fee: " + SavingsAccount.transactionFee);
	}
}
