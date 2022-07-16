package thread;

public class Store {
	 volatile int tickets = 0;
	 boolean flag = true;
	 Object obj = new Object();
	 public void produce() {
		 while(flag) {
			 synchronized (this.obj) {
				 try {
					 Thread.sleep(100);
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
				 
				 while(tickets==10) {
					 try {
						 this.obj.wait();
					 } catch (InterruptedException e) {
						 e.printStackTrace();
					 }
				 }
				 
				 tickets ++;
				 System.out.println(Thread.currentThread().getName() +"生产，剩余"+tickets);
				 this.obj.notifyAll(); 
				 
			 }
		 }
	 }
	 
	 public void consume() {
		 while(flag) {
			 
			 synchronized (this.obj) {
				 try {
					 Thread.sleep(100);
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
				 
				 while(tickets==0) {
					 try {
						 this.obj.wait();
					 } catch (InterruptedException e) {
						 e.printStackTrace();
					 }
				 }
				 tickets --;
				 System.out.println(Thread.currentThread().getName() +"消费，剩余"+tickets);
				 this.obj.notifyAll();
			 }
		 }
	 }
	public void stop() {
		this.flag = false;
	}	 
}
