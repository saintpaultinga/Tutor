package org.mum.edu.ea.controller;

import javax.websocket.server.PathParam;

import org.mum.edu.ea.auth.UserValidator;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.serviceimpl.SecurityServiceImpl;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
   @Autowired	
   private UserValidator userValidator;
   @Autowired
   WebUserServiceImpl userService;
   @Autowired
   private SecurityServiceImpl securityService;
   
	// defaul page (just for testing)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "home";
	}
	// defaul page (just for testing)
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomem(Model model) {
		
		return "welcome";
	}
	// defaul page (just for testing)
		@RequestMapping(value = "/registration", method = RequestMethod.GET)
		public String registrationForm(Model model) {
			model.addAttribute("userForm", new WebUser());
			return "registration";
		}


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") WebUser userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        WebUser userExists = userService.findByEmail(userForm.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getConfirmedpassword());

        return "redirect:/";
    }
	public String findAllUser(Model model) {

		return "/userlist";
	}

	@RequestMapping("/UserDetail")
	public String UserDetail(@PathParam("id") Long id, Model model) {

		return "userDetail";
	}
	
	@RequestMapping(value="/user/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebUser user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", user.getUsername());
		modelAndView.setViewName("user/home");
		return modelAndView;
	}
	

}
