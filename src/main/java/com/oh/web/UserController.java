/**
 * 
 */
package com.oh.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oh.bean.User;
import com.oh.comm.exception.MyHomeException;
import com.oh.service.UserService;

/**
 * @Description TODO
 * @author Owen.he
 * @date May 18, 2016
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger LOG = LoggerFactory.getLogger("errorFile");
	@Autowired
	private UserService userService;
	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * 
	* @Description: query all user info.
	* @param request
	* @param response
	* @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("user/list");
		try {
			model.addObject("users", userService.queryAllUser());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	ModelAndView add(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:/user/list");
		if(user != null){
			User queryParamUser = new User();
			queryParamUser.setEmail(user.getEmail());
			user.setIp(request.getRemoteAddr());
			try {
				userService.insert(user);
			} catch (MyHomeException e) {
				LOG.error("Add user exception: {}", e.getMsg());
				model.addObject("error", e.getMsg());
				model.addObject("user", user);
				model.setViewName("user/edit");
			}
			
		}
		model.addObject("users", userService.queryAllUser());
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("user/edit");
		return model;
	}
}
