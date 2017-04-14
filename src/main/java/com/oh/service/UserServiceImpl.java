/**
 * 
 */
package com.oh.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oh.bean.User;
import com.oh.comm.exception.MyHomeException;
import com.oh.constant.ErrorCode;
import com.oh.dao.BaseDao;

/**
 * @Description User Service
 * @author Owen.he
 * @date May 18, 2016
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private static Logger LOG = LoggerFactory.getLogger("run");
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserService#queryAllUser()
	 */
	@Override
	public List<User> queryAllUser(){
		RowBounds RowBounds = new RowBounds(0, 5);
		List<User> users = baseDao.queryForListPagination("user.queryUsers", null, RowBounds);
		LOG.info("all users size={}", users.size());
		return users;
	}

	@Override
	public int insert(User user){
		if(user == null){
			return 0;
		}
		User existsUser = queryUser(user);
		if(existsUser != null){
			LOG.warn("User existis Email:{}", user.getEmail());
			throw new MyHomeException(ErrorCode.USER_EXISTS_CODE);
		}
		return baseDao.insert("user.insert", user);
	}

	@Override
	public User queryUser(User user){
		if(user == null){
			return null;
		}
		return baseDao.queryForObject("user.selectUser", user);
	}

}
