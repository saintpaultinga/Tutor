package org.mum.edu.ea.controller;

import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.service.WebUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {
	
	WebUserService webuserservice;
    //default page (just for testing)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "index";
	}
	@RequestMapping(value = "/signup",method=RequestMethod.GET)
	public String signup(){
		return "addUserAccount";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String saveUser(WebUser webuser) {
		webuserservice.create(webuser);
		return "redirect:addUserAccount";
	}
}
