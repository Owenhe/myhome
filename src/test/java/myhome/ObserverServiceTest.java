/**  
* @Title: WebServiceTest.java
* @Package myhome
* @version V1.0  
*/
package myhome;

import com.oh.observer.SimpleObservable;
import com.oh.observer.SimpleObserver;

/**
 * @ClassName: WebServiceTest
 * @Description: TODO
 * @author owen.he
 * @date Jul 27, 2016 4:28:53 PM
 *
 */
public class ObserverServiceTest {
	/**
	 * @Description: TODO
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 SimpleObservable doc = new SimpleObservable ();    
	      SimpleObserver view = new SimpleObserver (doc);    
	      SimpleObserver view2 = new SimpleObserver (doc);    
	      System.out.println(doc.countObservers());
	      doc.setData(1);    
	      doc.setData(2);    
	      doc.setData(2);    
	      doc.setData(3);    
	}

}
