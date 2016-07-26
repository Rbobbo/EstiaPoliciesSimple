package it.estia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import it.estia.entity.Policy;
import it.estia.entity.User;
import it.estia.entity.service.PolicyService;
import it.estia.entity.service.UserService;

@Controller
@RequestMapping("/home")
@Scope("session")
@SessionAttributes("userLocal")
public class HomeController
{
	@Autowired
	UserService userService;
	
	@Autowired
	PolicyService policyService;
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	    sdf.setLenient(true);
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
	
	@RequestMapping( method = RequestMethod.GET)
	public String login(HttpSession session,HttpServletRequest req, ModelMap model) {
	    AuthenticationException ase = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	    if (ase != null) {
	        model.addAttribute("errorMsg",ase.getMessage());
	        return "login";
	    }
	    return "home";
	}
	
//	User profile  handling 
	
	@RequestMapping("/profile")
	public String profileLoadLight()
	{
		
		return "profile";
	}
	
	@RequestMapping(value = "/editProfile" , method = RequestMethod.POST)
	public ModelAndView saveEditProfile( @ModelAttribute("userLocal") User userLocal, HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		
//		model.addObject("isOkSave","true");
		
		User userUpdated = userService.updateUser(userLocal);
		session.setAttribute("userLocal", userUpdated);
		
		model.setViewName("/home");
		return model;
	}
	
//	--------- Policy handler -------------
	
	@RequestMapping("/newPolicy")
	public String policyLoad( @ModelAttribute("userLocal") User userLocal )
	{
		
		return "newPolicy";
	}
	
	@RequestMapping("/addPolicy")
	public ModelAndView policyAdd( @ModelAttribute Policy policyToAdd,
					@ModelAttribute("userLocal") User userLocal ,
					HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		policyToAdd.setUserid(userLocal.getId());
		policyService.addPolicy(policyToAdd);
		session.setAttribute("successAddPolicy", "true");
		
		model.setViewName("redirect:/home");
		return model;
	}
	
	
	@RequestMapping(value = "/listPolicies", method = RequestMethod.GET)
	public String loadListPolicies( @ModelAttribute("userLocal") User userLocal, Model model)
	{
		List<Policy> listPolicies = policyService.getPolicyList(userLocal);
		model.addAttribute("listPoliciesAttribute", listPolicies);
		
		String view = "listPolicies";
		return "listPolicies";
	}
}
