/**  
* @Title: EventPublisher.java
* @Package event
*
*/
package event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @ClassName: EventPublisher
 * @Description: TODO
 * @author owen.he
 * @date Aug 10, 2016 9:51:13 AM
 *
 */
public class EventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher ctx;

	/**
	 * 
	 */
	public EventPublisher() {
		// TODO Auto-generated constructor stub
	}

	public void sendEmail(String address) {
		BlackListEvent event = new BlackListEvent(address);
		ctx.publishEvent(event);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationEventPublisherAware#
	 * setApplicationEventPublisher(org.springframework.context.
	 * ApplicationEventPublisher)
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.ctx = applicationEventPublisher;
	}

}
