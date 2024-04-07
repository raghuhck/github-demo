package RaceConditions;
//Check-Then-Act Race Condition
public class BankCheckThenWrite implements Runnable {
	int balance = 100;
	
	public void run() {
		System.out.println("Waiting to withdraw money : " + Thread.currentThread().getName());
		synchronized (this) {
			if (balance >= 100) {
				System.out.println("Withdrawing money : " + Thread.currentThread().getName());
				balance -= 50;
			} else {
				System.out.println("Withdrawal not done for : " + Thread.currentThread().getName());
				return;
			}
			System.out.println("Withdrawal done, final balance =" + balance);
		}
	}
	
	public static void main(String[] args) {
		BankCheckThenWrite bankCheckThenWrite = new BankCheckThenWrite();
		Thread ramesh = new Thread(bankCheckThenWrite, "ramesh");
		Thread payal = new Thread(bankCheckThenWrite, "payal");
		ramesh.start();
		payal.start();
	}
}
