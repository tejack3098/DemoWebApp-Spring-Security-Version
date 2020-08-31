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
import com.tejack.demo.service.OTPmailService;
import com.tejack.demo.service.RegisterService;
import com.tejack.demo.service.CustomUserDetailsService;

@Controller
@SessionAttributes("name")
public class RegisterController {
	@Autowired
	RegisterService service;

	@Autowired
	CustomUserDetailsService userDetails;

	@Autowired
	OTPmailService mailService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterUser(ModelAndView mv, @ModelAttribute User user, @RequestParam String c_pass) {

		if (!user.getPassword().equals(c_pass)) {

			mv.addObject("errorMessage", "Passwords doesn't match. Please check again!");
			mv.setViewName("login");
			return mv;
		}

		boolean chk_exists = userDetails.chk_email(user);

		if (chk_exists) {

			mv.addObject("errorMessage", "Email Id Already Exists!");
			mv.setViewName("login");
			return mv;

		}

		boolean isUserRegistered = service.RegisterUser(user);

		if (!isUserRegistered) {
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
