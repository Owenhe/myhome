/**  
* @Title: BlackListEvent.java
* @Package event
*
*/ 
package event;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.ApplicationEvent;

/**
* @ClassName: BlackListEvent
* @Description: TODO
* @author owen.he
* @date Aug 10, 2016 9:58:53 AM
*
*/
public class BlackListEvent extends ApplicationEvent {

	private Queue orderQueue = new ConcurrentLinkedQueue();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	/**
	 * @param source
	 */
	public BlackListEvent(String address) {
		super(address);
		this.address = address;
	}

}
