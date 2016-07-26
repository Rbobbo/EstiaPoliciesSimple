package it.estia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.estia.entity.Policy;
import it.estia.entity.User;
import it.estia.entity.service.PolicyService;
import it.estia.entity.service.UserService;

@Controller
@Scope("session")
@SessionAttributes("userLocal")
public class MainController
{
	@Autowired
	UserService userService;
	
	@Autowired
	PolicyService policyService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
//	User profile load
	@RequestMapping("/profile")
	public String profileLoad( Authentication auth, ModelMap model, HttpServletRequest request )
	{
		org.springframework.security.core.userdetails.User userFrameworkLocal = 
				(org.springframework.security.core.userdetails.User)auth.getPrincipal();
		String username = userFrameworkLocal.getUsername();
		User  userLocal = userService.getUser(username);
		
		request.getSession().setAttribute("userLocal", userLocal);
		
//		model.addAttribute("userload",userLocal);
		return "profile";
	}
	
	@RequestMapping("/newPolicy")
	public String policyLoad( @ModelAttribute("userLocal") User userLocal )
	{
		
		return "newPolicy";
	}
	
	@RequestMapping("/listPolicies")
	public String loadListPolicies( @ModelAttribute("userLocal") User userLocal, Model model,HttpServletRequest request  )
	{
		List<Policy> listPolicies = policyService.getPolicyList(userLocal);
		request.getSession().setAttribute("listPoliciesAttribute", listPolicies);
		
		String view = "listPolicies";
		return view;
	}

}