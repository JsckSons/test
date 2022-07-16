package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store2 {
	 volatile int tickets = 0;
	 boolean flag = true;
	 Object obj = new Object();
	 private Lock lock = new ReentrantLock();
	 private Condition condition = lock.newCondition();
	 public void produce() {
		 while(flag) {
			 lock.lock();
			 try {
				 Thread.sleep(100);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
			 
			 while(tickets==10) {
				 try {
					 condition.await();
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
			 }
			 
			 tickets ++;
			 System.out.println(Thread.currentThread().getName() +"生产，剩余"+tickets);
			 condition.signalAll();
			 lock.unlock();
		 }
	 }
	 
	 public void consume() {
		 while(flag) {
			 lock.lock();
			 try {
				 Thread.sleep(100);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
			 
			 while(tickets==0) {
				 try {
					 condition.await();
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
			 }
			 tickets --;
			 System.out.println(Thread.currentThread().getName() +"消费，剩余"+tickets);
			 condition.signalAll();
			 lock.unlock();
		 }
	 }
	public void stop() {
		this.flag = false;
	}	 
}
