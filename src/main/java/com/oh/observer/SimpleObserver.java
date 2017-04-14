/**  
* @Title: SimpleObserver.java
* @Package com.oh.observer
* @version V1.0  
*/
package com.oh.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: SimpleObserver
 * @Description: TODO
 * @author owen.he
 * @date Jul 29, 2016 10:47:49 AM
 *
 */
public class SimpleObserver implements Observer {

	/**
	 * 
	 */
	public SimpleObserver(SimpleObservable simpleObservable) {
		 simpleObservable.addObserver(this ); 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Data has changed to" + ((SimpleObservable) o).getData());
	}
}
