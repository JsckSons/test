package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountLock {
	
	/**
	 * 
	 *<p>Title: CountDownLatch<／p>
	 *<p>Description: 构造时添加门闩数量，待每一次countDown 门闩数减少至0时，门自动打开<／p>
	 * @author haitao
	 * @Date: 2019年10月25日 下午9:36:09
	 *
	 */
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			new Thread(()-> {
				System.out.println(Thread.currentThread().getName()+" 国被灭。。。。。");
				cdl.countDown();
				
			},Eumeration.getCountry(i).value).start();
			
		}
		cdl.await();
		
		new Thread(()-> {
			
			System.out.println("****** 秦国统一六国 ******  ");
		}).start();
		
	}

}
