package com.tejack.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LogoutContoller {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String LogoutUser(ModelMap model, SessionStatus status) {

		status.setComplete();
		return "redirect:login";
	}

}
