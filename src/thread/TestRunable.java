package thread;

public class TestRunable {

	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				synchronized (sb1) {
					sb1.append("A");
					try {
						Thread.currentThread().sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (sb2) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				synchronized (sb2) {
					sb2.append("C");
					try {
						Thread.currentThread().sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (sb1) {
						sb1.append("D");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
	}

}
