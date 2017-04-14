/**  
* @Title: MyHomeException.java
* @Package com.oh.comm.exception
* @Description: TODO
* @author owen.he  
* @date Jun 17, 2016 4:36:22 PM
* @version V1.0  
*/ 
package com.oh.comm.exception;

import com.oh.constant.ErrorCode;

/**
* @ClassName: MyHomeException
* @Description: TODO
* @author owen.he
* @date Jun 17, 2016 4:36:22 PM
*
*/
public class MyHomeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MyHomeException() {
		// TODO Auto-generated constructor stub
	}
	
	private ErrorCode error;
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public MyHomeException(Throwable e) {
		super(e);
		this.error = ErrorCode.ERROR_SYSTEM;
	}

	public MyHomeException(ErrorCode error, Throwable e) {
		super(e);
		this.error = error;
	}

	public MyHomeException(ErrorCode error, String errorMsg) {
		this.error = error;
		this.errorMsg = errorMsg;
	}

	public MyHomeException(ErrorCode error) {
		this.error = error;
	}

	public String getMsg() {
		if (error != null) {
			return error.getErrorMsg();
		}
		return "unkonwn error";
	}

	public int getErrorCode() {
		if (error != null) {
			return error.getCode();
		}
		return 0;
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

}
