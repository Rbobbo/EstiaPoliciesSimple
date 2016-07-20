package it.estia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController
{
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewSimple(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "ERROR MS MSG MSG");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
	@RequestMapping(value="home")
	public String viewSimpleHome()
	{
		
		
		return "home";
	}

}
