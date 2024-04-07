package RaceConditions;
// Read modify write race condition
public class MyCustomThread implements Runnable{
	
	int shared =0;
	
	@Override
	public void run() {
		for(int i=0;i<100000;i++) {
			shared++;
		}
	}

	public int getCount() {
		return shared;
	}

}
