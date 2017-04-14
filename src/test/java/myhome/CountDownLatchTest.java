/**  
 * @Title: CountDownLatchTest.java
 * @Package myhome
 *
 */ 
package myhome;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CountDownLatchTest
 * @Description: TODO
 * @author yi.he
 * @date Jan 10, 2017 10:23:44 AM
 *
 */
public class CountDownLatchTest {

	/**
	 * 
	 */
	public CountDownLatchTest() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);  
		Waiter waiter = new CountDownLatchTest().new Waiter(latch);
		Decrementer decrementer = new CountDownLatchTest().new Decrementer(latch); 
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(waiter);
		executorService.execute(decrementer);
		executorService.shutdown();
		
//		new Thread(waiter).start();  
//		new Thread(decrementer).start(); 
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	class Waiter implements Runnable {
		CountDownLatch latch = null;
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Waiter Released");  
		}
		
		public Waiter(CountDownLatch latch) {
			this.latch = latch;
		}
	}
	
	class Decrementer implements Runnable{
		CountDownLatch latch = null;  

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
	        try {  
	            Thread.sleep(1000);  
	            this.latch.countDown();
	            System.out.println(latch.getCount());
	            
	            Thread.sleep(1000);  
	            this.latch.countDown();  
	            System.out.println(latch.getCount());
	  
	            Thread.sleep(1000);  
	            this.latch.countDown();  
	            System.out.println(latch.getCount());
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
		}
		  
	    public Decrementer(CountDownLatch latch) {  
	        this.latch = latch;  
	    }  
	  
		
	}
}
