package Threads;

public class MyCustomThreadWtRunnableInterface implements Runnable{
	
	public void run() {
		System.out.println("My Custom Thread by implementing runnable interface " + Thread.currentThread().getName() );
	}

}
