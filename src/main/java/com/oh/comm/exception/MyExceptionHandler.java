/**  
* @Title: MyExceptionHandler.java
* @Package com.oh.comm.exception
* @Description: TODO
* @author owen.he  
* @date Jun 17, 2016 5:20:21 PM
* @version V1.0  
*/ 
package com.oh.comm.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
* @ClassName: MyExceptionHandler
* @Description: TODO
* @author owen.he
* @date Jun 17, 2016 5:20:21 PM
*
*/
public class MyExceptionHandler implements HandlerExceptionResolver {

	/**
	 * 
	 */
	public MyExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
        return new ModelAndView("error", model);  
	}

}
