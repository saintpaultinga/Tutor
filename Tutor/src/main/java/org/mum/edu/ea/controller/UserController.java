package org.mum.edu.ea.controller;


import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
    //defaul page (just for testing)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "index";
	}
	
	public String findAllUser(Model model) {
		
		
		
		return "/userlist";
	}
	
	@RequestMapping("/UserDetail")
	public String UserDetail(@PathParam("id") Long id, Model model) {
		
		return "userDetail";
	}
	
	
}
