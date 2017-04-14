/**  
* @Title: JsonUtil.java
* @Package com.oh.util
* @Description: TODO
* @author owen.he  
* @date Jul 14, 2016 11:18:44 AM
* @version V1.0  
*/
package com.oh.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	/***
	 * 
	* @Description: Object to string
	* @param obj
	* @return json string
	 */
	public static String toJsonString(Object obj) {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			mapper.writeValue(out, obj);
			byte[] bytes = out.toByteArray();
			
			return new String(bytes, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(out);
		}
		return null;
	}
}
