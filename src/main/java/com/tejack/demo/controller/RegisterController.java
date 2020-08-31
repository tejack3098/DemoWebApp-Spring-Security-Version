package com.tejack.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tejack.demo.model.User;
import com.tejack.demo.service.MyUserDetailsService;
import com.tejack.demo.service.OTPmailService;


@Controller
@SessionAttributes("name")
public class RegisterController {

	@Autowired
	OTPmailService mailService;
	
	@Autowired
	MyUserDetailsService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterUser(ModelAndView mv, @ModelAttribute User user, @RequestParam String c_pass) {

		if (!user.getPassword().equals(c_pass)) {

			mv.addObject("errorMessage", "Passwords doesn't match. Please check again!");
			mv.setViewName("login");
			return mv;
		}

		try {
			
			userService.signUpUser(user);
			
		}catch(Exception e) {
			
			mv.addObject("errorMessage", "Invalid Credentials");
			mv.setViewName("login");
			return mv;	
			
		}

		boolean mailStatus = mailService.MailOTP(user.getEmail());

		mv.addObject("email", user.getEmail());

		if (mailStatus) {
			mv.addObject("errorMessage", "");
			mv.setViewName("redirect:getotp");
			return mv;

		} else {
			mv.addObject("errorMessage", "OTP not Send");
			mv.setViewName("login");
			return mv;
		}

	}

}
