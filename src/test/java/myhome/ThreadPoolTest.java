/**  
* @Title: ThreadPoolTest.java
* @Package myhome
*
*/ 
package myhome;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @ClassName: ThreadPoolTest
* @Description: TODO
* @author owen.he
* @date Jul 29, 2016 2:59:30 PM
*
*/
public class ThreadPoolTest {

	/**
	 * 
	 */
	public ThreadPoolTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);  
        MyThread a=new MyThread("A");  
        MyThread b=new MyThread("B");  
        MyThread c=new MyThread("C");  
        MyThread d=new MyThread("D");  
          
          
        executorService.execute(a);  
        executorService.execute(b);  
        executorService.execute(c);  
        executorService.execute(d);  
          
          
        executorService.shutdown();  
	}
	
	static class MyThread implements Runnable{  
        private String name;  
        public MyThread(String name){  
            this.name=name;  
        }  
        @Override  
        public void run(){  
            for(int i=1;i<=5;i++){  
                System.out.println(this.name+"第"+i+"次运行.........");  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  

}
