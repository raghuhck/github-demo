package Threads;

public class NewThread {

	public static void main(String[] args) {
		MyCustomThreadWithThreadClass t1 = new MyCustomThreadWithThreadClass();
		t1.start();
		
		MyCustomThreadWithThreadClass t2 = new MyCustomThreadWithThreadClass();
		t2.start();
		
		MyCustomThreadWtRunnableInterface myCustomThreadWithRunnableInterface= new MyCustomThreadWtRunnableInterface();
		Thread t3 = new Thread(myCustomThreadWithRunnableInterface);
		t3.start();
		
		Thread t4 = new Thread(myCustomThreadWithRunnableInterface);
		t4.start();
	}

}
