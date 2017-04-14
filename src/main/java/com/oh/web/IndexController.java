/**
 * 
 */
package com.oh.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description TODO
 * @author Owen.he
 * @date May 18, 2016
 *
 */
@Controller
public class IndexController {

	/**
	 * 
	 */
	public IndexController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model, HttpServletRequest request, HttpServletResponse response){
		return "index";
	}
}
