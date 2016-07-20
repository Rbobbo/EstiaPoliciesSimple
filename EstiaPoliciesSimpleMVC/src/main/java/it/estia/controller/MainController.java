package it.estia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController
{
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("login");
//
//		return model;
//
//	}

	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String login(HttpSession session,HttpServletRequest req, ModelMap model) {
	    AuthenticationException ase = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	    if (ase != null) {
	        model.addAttribute("errorMsg",ase.getMessage());
	        return "login";
	    }
	    return "home";
	}
}