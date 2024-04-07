package Threads;

public class DaemonThreadExample2 {

	public static void main(String[] args) {
		Thread userThread = new Thread(() -> {
			try {
	            for(int i=0;i<=10;i++) {
	            	System.out.println("User Thread :" + i);
	            	Thread.sleep(1000);
	            }
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
		Thread daemonThread = new Thread(() -> {
                try {
                	 for(int i=0;i<=10;i++) {
                		System.out.println("Deamon Thread :" + i); // Simulate some background task
     	            	Thread.sleep(2000);
                	 }                     
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        });
		
        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start(); // Start the daemon thread
        userThread.start();
	}

}
