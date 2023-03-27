package ca.mcgill.cs.swdesign.m9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
	   final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 
	
	   final Object[] items = new Object[100];
	   int putptr, takeptr, count;
	
	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length)
	         notFull.await();
	       items[putptr] = x;
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }
	
	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0)
	         notEmpty.await();
	       Object x = items[takeptr];
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   }
	   
	   public static void main(String[] args) throws InterruptedException {
		   BoundedBuffer buffer = new BoundedBuffer();
		   final Thread t1 = new Thread( new Runnable() {
				@Override
				public void run()
				{	
					try
					{
						for(int i = 0;i<2000;i++)
							buffer.put(Integer.valueOf(i));
					}
					catch (InterruptedException e)
					{
						System.out.printf("\nPutting Action Interrupted\n");
					}
				}
		   });
		   Thread t2 = new Thread( new Runnable() {
				@Override
				public void run()
				{			
					try
					{
						for(int i = 0;i<2000;i++) {
							System.out.println(buffer.take());	
						}
					}
					catch (InterruptedException e)
					{
						System.out.printf("\nTaking Action Interrupted\n");

					}
				}
		   });
		   t1.start();
		   t2.start();
		   Thread.sleep(5000);
		   System.out.printf("Buffer count now: %s\n", buffer.count);
	   }
	 
	   


}