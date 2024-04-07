package SynchronizedBlocksMethods;

public class BankSynchronizationDemo {
	private double balance = 100;
	
	public BankSynchronizationDemo(double initalBalance) {
		this.balance = initalBalance;
	}
	
	
	public void deposit(double amount) {
		synchronized(this) {
			double newBalance = amount + balance;
			System.out.println(Thread.currentThread().getName() + " is running with updated balance =" + newBalance);
			// Simulating some processing time
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			balance = newBalance;
		}
		System.out.println(Thread.currentThread().getName() + " is running with updated balance ="+ balance);
	}
	
	
	public void withdraw(double amount) {
		synchronized (this) {
			if (balance >= amount) {
				double newBalance = balance - amount;
				System.out
						.println(Thread.currentThread().getName() + " is running with updated balance =" + newBalance);
				// Simulating some processing time
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				balance = newBalance;
			}
			System.out.println(Thread.currentThread().getName() + " is running with updated balance ="+ balance);
		}
	}
	
	public double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		BankSynchronizationDemo account = new BankSynchronizationDemo(100);
		
		Thread deposit1 = new Thread(() -> account.deposit(40),"deposit1");
		Thread deposit2 = new Thread(() -> account.deposit(50),"deposit2");
		
		Thread withdraw1 = new Thread(() -> account.withdraw(30),"withdraw1");
		Thread withdraw2 = new Thread(() -> account.withdraw(50),"withdraw2");
		
		deposit1.start();
		deposit2.start();
		withdraw1.start();
		withdraw2.start();
		
		try {
			deposit1.join();
			deposit2.join();
			withdraw1.join();
			withdraw2.join();
		}catch(InterruptedException e) {
			
		}
		
		System.out.println("Final Balance = "+ account.getBalance());
	}

}
