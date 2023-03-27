package ca.mcgill.cs.swdesign.m9;

public class WaitToBeReady
{
	private boolean ready = false;

	public synchronized void prepare() {
		while(!ready){
			System.out.print("*");
			try {
				wait(1000); // try change to Thread.sleep(1000); and observe the hold of lock
				System.out.println("End of waiting");
			} catch (InterruptedException e) {
				System.out.println("Waiting Interrupted");

			}
		}
		System.out.println("I am ready!");
	}
	
	public synchronized void setReady() {
		ready = true;
		this.notifyAll();
	}
	
	public static void main(String[] args)
	{
		WaitToBeReady person = new WaitToBeReady();
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				person.prepare();
			}}

		);

		// Using lambda expression to replace anonymous class.
		Thread t2 = new Thread(() -> {
			for(int i=0;i<100;i++) {
				System.out.print(".");
			}
			System.out.printf("\nDone counting, and to set ready\n");
			person.setReady();
		});

		t1.start();
		t1.interrupt();
		t2.start();

	}

}
