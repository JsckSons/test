package thread;

public class ProduceConsume2 {

	public static void main(String[] args) {
		Store s1  = new Store();
		Thread t1 = new Thread(new Producer(s1),"T1");
		Thread t2 = new Thread(new Producer(s1),"T2");
		Thread t3 = new Thread(new Producer(s1),"T3");
		Thread t4 = new Thread(new Consumer(s1),"T4");
		Thread t5 = new Thread(new Consumer(s1),"T5");
		//Thread t6 = new Thread(new Consumer(s1),"T6");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		//t6.start();
		//s1.stop();
	}

}
class Producer2 implements Runnable{

	Store2 store;
	Producer2(Store2 store){
		this.store = store;
	}
	@Override
	public void run() {
		while(true) {
			store.produce();
		}
	}
	
}
class Consumer2 implements Runnable{

	Store2 store;
	Consumer2(Store2 store){
		this.store = store;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			store.consume();
			
		}
	}
	
}