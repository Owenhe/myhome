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
@RequestMapping("/sigup")
public class SigupController {
	private static Logger LOG = LoggerFactory.getLogger("errorFile");
	
	@Autowired
	private UserService userService;
	/**
	 * 
	 */
	public SigupController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/sigup", method = RequestMethod.POST)
	ModelAndView sigupUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
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
	
	@RequestMapping(value = "/sigup", method = RequestMethod.GET)
	ModelAndView sigup(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
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
}
