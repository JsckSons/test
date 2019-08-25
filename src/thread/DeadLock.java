package thread;

public class DeadLock {

	public static String obj1 = "obj1";
	public static String obj2 = "obj2";
	public static void main(String[] args) {
		Thread t1 = new Thread(new Lock1(),"T1");
		Thread t2 = new Thread(new Lock2(),"T2");

		t1.start();
		t2.start();
	}

}
class Lock1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Lock1 running");
		while(true) {
			synchronized (DeadLock.obj1) {
				System.out.println("Lock1 持有 obj1");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (DeadLock.obj2) {
					System.out.println("Lock1 持有 obj2");
				}
			}
		}
	}
	
}
class Lock2 implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Lock2 running");
		while(true) {
			synchronized (DeadLock.obj2) {
				System.out.println("Lock2 持有 obj2");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (DeadLock.obj1) {
					System.out.println("Lock2 持有 obj1");
				}
			}
		}
	}
	
}