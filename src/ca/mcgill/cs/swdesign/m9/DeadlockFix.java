package ca.mcgill.cs.swdesign.m9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockFix
{

    static class Friend {
    	private final Lock lock = new ReentrantLock();
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        
        private boolean checkLock(Friend bower) {
        	boolean myLock = this.lock.tryLock();
        	boolean friendLock = bower.lock.tryLock();
        	if (myLock && friendLock)
        		return true;
        	else if (myLock)
        		this.lock.unlock();
        	else if (friendLock)
        		bower.lock.unlock();
        	System.out.printf("Thread %s fails to obtain locks \n", Thread.currentThread().toString());
        	return false;
        }
       
     
        public void bow(Friend bower) {
        	if(checkLock(bower)) {
        		try {
		            System.out.format("%s: %s"
		                + "  has bowed to me!%n", 
		                this.name, bower.getName());
		            bower.bowBack(this);
		        	System.out.printf("Thread %s succeeds to obtain locks \n", Thread.currentThread().toString());
        		} finally {
        			this.lock.unlock();
                	bower.lock.unlock();
        		}
        	}
        }
        
        public void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        Thread.currentThread().sleep(1);
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}