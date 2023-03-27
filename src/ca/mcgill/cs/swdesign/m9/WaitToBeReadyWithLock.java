package ca.mcgill.cs.swdesign.m9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class WaitToBeReadyWithLock
{
	private boolean ready = false;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Condition addCond = lock.newCondition();
	
	public void prepare() {
		lock.lock();
		try {
			while(!ready)			
			{
				condition.await();
			}
			System.out.println("I am ready!");
		}
		catch (InterruptedException e)
		{
			System.out.println("I am interrupted!");
		}
		
		 finally {
			lock.unlock();
		}
		
	}
	
	public void setReady() {
		lock.lock();
		try {
			ready = true;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args)
	{
		WaitToBeReadyWithLock person = new WaitToBeReadyWithLock();		
		final Thread t1 = new Thread( new Runnable() {
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
		t2.start();		
		
	}

}

