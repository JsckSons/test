package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierStudy {
	
	/**
	 * 
	 *<p>Title: CyclicBarrier <／p>
	 *<p>Description: <／p>
	 * @author haitao
	 * @Date: 2019年10月25日 下午9:44:41
	 *
	 */
	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
			System.out.println("*******龙珠已经集齐了*******");
		}) ;
		for (int i = 1; i <= 7; i++) {
			new Thread(()-> {
				try {
					System.out.println(Thread.currentThread().getName()+"  个龙珠已获得 ******");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
		
	}

}
