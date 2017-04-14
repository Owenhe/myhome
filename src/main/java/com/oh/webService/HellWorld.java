/**  
* @Title: HellWorld.java
* @Package com.oh.webService
* @author owen.he  
* @date Jul 27, 2016 3:19:38 PM
* @version V1.0  
*/ 
package com.oh.webService;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
* @ClassName: HellWorld
* @Description: TODO
* @author owen.he
* @date Jul 27, 2016 3:19:38 PM
*
*/
@WebService
public interface HellWorld {
	String sayHi(@WebParam String text);
}
