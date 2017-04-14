/**  
* @Title: LogAspect.java
* @Package com.oh.util
* @Description: TODO
* @author owen.he  
* @date Jun 28, 2016 3:26:25 PM
* @version V1.0  
*/ 
package com.oh.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* @ClassName: LogAspect
* @Description: log aspect
* @author owen.he
* @date Jun 28, 2016 3:26:25 PM
*
*/
@Aspect
@Component
public class LogAspect {

	/**
	 * 
	 */
	public LogAspect() {
		// TODO Auto-generated constructor stub
	}

	@Pointcut("execution(* com.oh.service.*.insert*(..))")
	void insertServiceCall(){}
	
	@Pointcut("execution(* com.oh.service.*.query*(..))")
	void queryServiceCall(){}
	
	@AfterReturning(value = "insertServiceCall() && args(param)", argNames = "param")
	void insertServiceAdvice(JoinPoint joinPoint, Object param){
		long start = System.currentTimeMillis();
		System.out.println(joinPoint.getKind() + " after Returning advice..." + JsonUtil.toJsonString(param) + " Time:"+ (System.currentTimeMillis() -start));
	}
	
	@Around(value = "queryServiceCall()")
	Object queryServiceAdvice(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		Object retObject = null;
		Signature signatureObject = pjp.getSignature();
//		System.out.println(JsonUtil.toJsonString(signatureObject));
		retObject = pjp.proceed();
		System.out.println(signatureObject.getDeclaringTypeName() +"." + signatureObject.getName() + " [" +pjp.getKind() + "] Time:" + (System.currentTimeMillis() -start));
		return retObject;
	}
}
