/**  
* @Title: WebServiceTest.java
* @Package myhome
* @version V1.0  
*/
package myhome;

import javax.xml.ws.Endpoint;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.oh.webService.HelloWorldImpl;

/**
 * @ClassName: WebServiceTest
 * @Description: TODO
 * @author owen.he
 * @date Jul 27, 2016 4:28:53 PM
 *
 */
public class WebServiceTest {
/*
	protected WebServiceTest() throws Exception {  
        // START SNIPPET: publish  
        System.out.println("Starting Server");  
        HelloWorldImpl implementor = new HelloWorldImpl();  
        String address = "http://localhost:8888/helloWorld";  
        Endpoint.publish(address, implementor);  
        // END SNIPPET: publish  
    }
*/
	/**
	 * @Description: TODO
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*new WebServiceTest();  
        System.out.println("Server ready...");  
  
        Thread.sleep(5 * 60 * 1000);  
        System.out.println("Server exiting");  
        System.exit(0);  */
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
	    Client client = dcf.createClient(" http://localhost:9999/myhome/cxf/HelloWorld?wsdl"); 
	            //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组 
	    Object[] objects=client.invoke("sayHi", "张三");    
	    //输出调用结果 
	    System.out.println(objects[0].toString()); 
	}

}
