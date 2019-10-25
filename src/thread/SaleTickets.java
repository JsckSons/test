package thread;

public class SaleTickets {

	public static void main(String[] args) {
		SaleTicket s1  = new SaleTicket();
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);
		Thread t3 = new Thread(s1);

		t1.start();
		t2.start();
		t3.start();
	}

}
class SaleTicket implements Runnable{

	int ticket = 100;
	@Override
	public void run() {
		while(true) {
			synchronized (SaleTicket.class) {
				if(ticket > 0) {
					/*
					 * try { Thread.currentThread().sleep(100); } catch (InterruptedException e) {
					 * // TODO Auto-generated catch block e.printStackTrace(); }
					 */
					System.out.println(Thread.currentThread().getName() +" €∆±£¨ £”‡"+ticket--);
				}else {
					break;
				}
			}
			
		}
		
	}
	
}
