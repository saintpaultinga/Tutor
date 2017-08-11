package org.mum.edu.ea.controller;

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

}
