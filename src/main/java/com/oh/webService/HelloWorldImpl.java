/**  
* @Title: HelloWorldImpl.java
* @Package com.oh.webService
* @version V1.0  
*/ 
package com.oh.webService;

import javax.jws.WebService;

/**
* @ClassName: HelloWorldImpl
* @Description: TODO
* @author owen.he
* @date Jul 27, 2016 3:22:15 PM
*
*/
@WebService(endpointInterface = "com.oh.webService.HellWorld")
public class HelloWorldImpl implements HellWorld {

	/**
	 * 
	 */
	public HelloWorldImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.webService.HellWorld#sayHi(java.lang.String)
	 */
	@Override
	public String sayHi(String text) {
		 System.out.println("sayHi called");
	     return "Hello " + text;
	}

}
