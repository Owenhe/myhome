/**
 * 
 */
package com.oh.service;

import java.util.List;

import com.oh.bean.User;
import com.oh.comm.exception.MyHomeException;

/**
 * @Description UserService
 * @author Owen.he
 * @date May 18, 2016
 *
 */
public interface UserService {

	/***
	 * 
	 * @Description query all user
	 * @return
	 */
	List<User> queryAllUser();

	/***
	 * 
	* @Description: insert user info.
	* @param user
	* @return
	* @throws MyHomeException
	 */
	int insert(User user) throws MyHomeException;
	
	/***
	 * 
	* @Description: query one user
	* @param user
	* @return
	 */
	User queryUser(User user);
}
