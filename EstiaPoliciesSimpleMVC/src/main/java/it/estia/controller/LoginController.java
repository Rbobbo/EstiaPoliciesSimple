package it.estia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import it.estia.entity.User;
import it.estia.entity.service.UserService;


@Controller
@Scope("session")
@SessionAttributes()
public class LoginController
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User userToAdd)
	{
		
		ModelAndView model = new ModelAndView();
		
		userToAdd.setRole("ROLE_USER");
		userService.addUser(userToAdd);
		
		model.addObject("isRegistered", "true");
		model.addObject("utenteAggiunto", userToAdd.getLogincode());
		model.setViewName("login");
		
		return model;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView viewSimple( @RequestParam(value = "error", required = false) String error,
			 @RequestParam(value = "logout", required = false)
			String logout,HttpServletRequest request )
	{
		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "ERROR MS MSG MSG");
		}

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");

		return model;
	}


}
