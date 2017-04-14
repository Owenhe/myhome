/**  
* @Title: ErrorCode.java
* @Package com.oh.constant
* @Description: TODO
* @author owen.he  
* @date Jun 16, 2016 3:34:33 PM
* @version V1.0  
*/ 
package com.oh.constant;

/**
* @ClassName: ErrorCode
* @Description: TODO
* @author owen.he
* @date Jun 16, 2016 3:34:33 PM
*
*/
public enum ErrorCode {
	ERROR_SYSTEM(1000, "System exception"),
	
	USER_EXISTS_CODE(20001, "User exitsts."),
	USER_DEL_ERROR(20002, "Delete user fail.");
	
	private int code;
	private String errorMsg;
	
	ErrorCode(int code, String errorMsg){
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
