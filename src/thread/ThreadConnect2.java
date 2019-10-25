package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadConnect2 {
	static Lock lock ;
	static Condition c1 ;
	static Condition c2 ;
	static Condition c3 ;
	public static void main(String[] args) throws InterruptedException {
		Sale s1  = new Sale();
		lock = new ReentrantLock();
		c1 = lock.newCondition();
		c2 = lock.newCondition();
		c3 = lock.newCondition();
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);
		Thread t3 = new Thread(s1);

		t1.start();
		//t1.join();
		t2.start();
		//t2.join();
		t3.start();
	}

}
class Sale implements Runnable{

	int ticket = 100;
	int count = 0;
	
	@Override
	public void run() {
		while(ticket>0) {
			synchronized (this) {
				notify();
				if(ticket > 0) {
					  try { Thread.currentThread().sleep(100); } catch (InterruptedException e) {
						  e.printStackTrace();
					  }
					System.out.println(Thread.currentThread().getName() +" €∆±£¨ £”‡"+ticket--);
				}else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
