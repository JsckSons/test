package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadConnect {
	static Lock lock ;
	static Condition c1 ;
	static Condition c2 ;
	static Condition c3 ;
	static int count = 100;
	public static void main(String[] args) throws InterruptedException {
		lock = new ReentrantLock();
		c1 = lock.newCondition();
		c2 = lock.newCondition();
		c3 = lock.newCondition();
		new Thread(new Runnable() {
				public void run() {
					while(count>0) {
						lock.lock();
						try {
							if(count % 3 != 0) {
								c1.await();
							}
							System.out.println(Thread.currentThread().getName()+" :"+count--);
							c2.signal();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							lock.unlock();
						}
					}
				}
			} ).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(count>0) {
					lock.lock();
					try {
						if(count % 3 != 1) {
							c2.await();
						}
						System.out.println(Thread.currentThread().getName()+" :"+count--);
						c3.signal();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						lock.unlock();
					}
				}
			}
		} ).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(count>0) {
					lock.lock();
					try {
						if(count % 3 != 2) {
							c3.await();
						}
						System.out.println(Thread.currentThread().getName()+" :"+count--);
						c1.signal();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						lock.unlock();
					}
				}
			}
		} ).start();
	
	}

}
