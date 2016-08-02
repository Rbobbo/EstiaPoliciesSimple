package it.estia.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

import it.estia.controller.utils.PdfMaker;
import it.estia.controller.utils.UtilController;
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
	
	@RequestMapping( method = RequestMethod.GET)
	public String login(HttpSession session,HttpServletRequest req, ModelMap model) {
	    AuthenticationException ase = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	    if (ase != null) {
	        model.addAttribute("errorMsg",ase.getMessage());
	        return "login";
	    }
	    return "home";
	}
	
//	--------- User profile  handling ---------
	
	@RequestMapping("/profile")
	public String profileLoadLight()
	{
		
		return "profile";
	}
	
	@RequestMapping(value = "/editProfile" , method = RequestMethod.POST)
	public ModelAndView saveEditProfile( @ModelAttribute("userLocal") User userLocal, HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		
		User userUpdated = userService.updateUser(userLocal);
		session.setAttribute(UtilController.CONFIRM_MESSAGE_ATTRIBUTE,"Utente modificato correttamente");
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
		session.setAttribute(UtilController.CONFIRM_MESSAGE_ATTRIBUTE, "Polizza aggiunta correttamente");
		
		model.setViewName("redirect:/home");
		return model;
	}
	
	
	@RequestMapping(value = "/listPolicies", method = RequestMethod.GET)
	public String loadListPolicies( @ModelAttribute("userLocal") User userLocal, Model model)
	{
		List<Policy> listPolicies = policyService.getPolicyList(userLocal);
		model.addAttribute("listPoliciesAttribute", listPolicies);
		
		String view = "listPolicies";
		return view;
	}
	
	@RequestMapping(value = "/generatePdf", method = RequestMethod.GET)
	public void printPolicy(@RequestParam("policyId")String policyId,@ModelAttribute("userLocal") User userLocal ,
			HttpServletRequest request, HttpServletResponse response,HttpSession session, Model model)
	{
		session.setAttribute("userLocal", userLocal);
		PdfMaker maker  = new PdfMaker();
		String docDownloadName = "";
		File file = null;
		try
		{
			docDownloadName = maker.getPdf(policyService.getPolicy(new Integer(policyId)));
			file = new File(docDownloadName);
		}
		catch (FileNotFoundException | DocumentException e)
		{
			e.printStackTrace();
		}
		
//		response.setContentType("application/octet-stream");
		response.setContentType("application/pdf");
//		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
		 
		  /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
//        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream;
		try
		{
			inputStream = new BufferedInputStream(new FileInputStream(file));
			//Copy bytes from source to destination(outputstream in this example), closes both streams.
			FileCopyUtils.copy(inputStream, response.getOutputStream());
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		
	}
	
	
	
	
	
}
