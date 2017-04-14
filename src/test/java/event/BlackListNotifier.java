/**  
* @Title: BlackListNotifier.java
* @Package event
*
*/ 
package event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
* @ClassName: BlackListNotifier
* @Description: TODO
* @author owen.he
* @date Aug 10, 2016 10:00:34 AM
*
*/
public class BlackListNotifier implements ApplicationListener<ApplicationEvent> {

	/**
	 * 
	 */
	public BlackListNotifier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event);  
        if (event instanceof BlackListEvent) {  
            System.out.println(((BlackListEvent) event).getAddress());  
        }  
	}

}
