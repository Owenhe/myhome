/**  
* @Title: TestEvent.java
* @Package event
*
*/
package event;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: TestEvent
 * @Description: TODO
 * @author owen.he
 * @date Aug 10, 2016 10:24:53 AM
 *
 */
public class TestEvent {

	private static Scanner sc = null;
	private static ApplicationContext ctx = null;

	/**
	 * 
	 */
	public TestEvent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
		EventPublisher eventPublisher = (EventPublisher) ctx .getBean("eventPublisher");
		while (true) {
			sc  = new Scanner(System.in);
			System.out.println("ScannerTest, Please Enter Name:");
			String name = sc .nextLine();
			System.out.println("Your Information is as below:");
			System.out.println("Name:" + name);
			if (name.equals("0")) {
				sc .close();
				break;
			}
			eventPublisher.sendEmail(name);
		}
	}

}
