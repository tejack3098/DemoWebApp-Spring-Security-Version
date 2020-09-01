package com.tejack.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/welcome")
    public String showDashBoard(ModelMap model){
        return "welcome";
    }
	
	@RequestMapping(value="/admin")
    public String showAdminPage(ModelMap model){
        return "admin";
    }
	
	@RequestMapping(value="/403")
    public String AccessDenial(ModelMap model){
        return "accessdenied";
    }


}
