/**  
* @Title: SimpleObservable.java
* @Package com.oh.observer
* @version V1.0  
*/
package com.oh.observer;

import java.util.Observable;

/**
 * @ClassName: SimpleObservable
 * @Description: TODO
 * @author owen.he
 * @date Jul 29, 2016 10:46:01 AM
 *
 */
public class SimpleObservable extends Observable {

	/**
	 * 
	 */
	public SimpleObservable() {
		// TODO Auto-generated constructor stub
	}

	private int data = 0;

	public int getData() {
		return data;
	}

	public void setData(int i) {
		if (this.data != i) {
			this.data = i;
			setChanged();

			// only call setChange() after the notifyObservers() will call update()
			notifyObservers();
		}
	}
}
