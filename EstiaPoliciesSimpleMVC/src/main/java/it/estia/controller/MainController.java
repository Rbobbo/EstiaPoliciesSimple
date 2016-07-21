package it.estia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.estia.entity.User;
import it.estia.entity.UserService;

@Controller
@Scope("session")
@SessionAttributes("userLocal")
public class MainController
{
	@Autowired
	UserService userService;

	@RequestMapping("/logout")
	public String logout()
	{
		
		
		return "login";
	}
	
//	User profile load
	@RequestMapping("/profile")
	public String profileLoad( Authentication auth, ModelMap model, HttpServletRequest request )
	{
		User userLoad = new User();
		org.springframework.security.core.userdetails.User userFrameworkLocal = 
				(org.springframework.security.core.userdetails.User)auth.getPrincipal();
		String username = userFrameworkLocal.getUsername();
		User  userLocal = userService.getUser(username);
		
		request.getSession().setAttribute("userLocal", userLocal);
		
		model.addAttribute("userload",userLoad);
		return "profile";
	}
	
	@RequestMapping("/newPolicy")
	public String policyLoad( @ModelAttribute("userLocal") User userLocal )
	{
		
		return "newPolicy";
	}
	
	@RequestMapping("/listPolicies")
	public String loadListPolicies( @ModelAttribute("userLocal") User userLocal )
	{
		
		
		return "listPolicies";
	}
	
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