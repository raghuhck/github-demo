package RaceConditions;

public class Main {

	public static void main(String[] args) {
		MyCustomThread customThread = new MyCustomThread();
		Thread t1 = new Thread(customThread);
		Thread t2 = new Thread(customThread);
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final Value:" + customThread.getCount());
	}

}
