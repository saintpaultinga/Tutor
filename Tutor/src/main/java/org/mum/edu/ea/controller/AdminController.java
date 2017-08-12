package org.mum.edu.ea.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
	WebUserServiceImpl userservice;
	
	@RequestMapping("/login")
	public String admin(Model model){
		return "admin/login";
	}
	
	@RequestMapping("/dashboard")
	public String adminView(Model model){
		return "admin/dashboard";
	}

	@RequestMapping(value="/display", method=RequestMethod.GET)
	//@GetMapping("/display")
	public String  userDisplay(Model model){
		List<WebUser> userlist = userservice.findAll();
		model.addAttribute("user",userlist);
		return "admin/displayuser";
	
	}


}
