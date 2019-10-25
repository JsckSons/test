package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreStudy {
	
	/**
	 * 
	 *<p>Title: SemaphoreStudy <／p>
	 *<p>Description: 排队进入，适合抢红包等场景<／p>
	 * @author haitao
	 * @Date: 2019年10月25日 下午9:44:41
	 *
	 */
	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(3);//3个停车位
		for (int i = 1; i <= 7; i++) {//模拟有6辆车
			new Thread(()-> {
				try {
					semaphore.acquire();
					System.out.println("第  "+Thread.currentThread().getName()+" 抢到了车位");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("第  "+Thread.currentThread().getName()+" 离开车位");
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			},String.valueOf(i)).start();
		}
		
	}

}
