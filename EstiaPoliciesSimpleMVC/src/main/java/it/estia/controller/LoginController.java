package it.estia.controller;

import java.util.ArrayList;

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

import it.estia.controller.utils.UtilController;
import it.estia.entity.User;
import it.estia.entity.service.UserService;


@Controller
@Scope("session")
@SessionAttributes()
public class LoginController
{
	@Autowired
	UserService userService;
	
//	Register handlers
	@RequestMapping(value = "/login/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User userToAdd)
	{
		
		ModelAndView model = new ModelAndView();
		
		ArrayList<String> confirmBeforePersist = isOkRegisterInfo(userToAdd);
		if(confirmBeforePersist.equals(""))
		{
//			userToAdd.setRole("ROLE_USER");
//			userService.addUser(userToAdd);
//			
//			model.addObject("isRegistered", "true");
//			model.addObject("utenteAggiunto", userToAdd.getLogincode());
		}
		else
		{
			model.addObject("isRegistered", "false");
			model.addObject( "error", UtilController.formatErrorsTag(confirmBeforePersist) );
		}
		
		model.setViewName("login");
		return model;
	}
	
	private ArrayList<String> isOkRegisterInfo(User userToAdd)
	{
		ArrayList<String> result = new ArrayList<String>();
//		check login code
		String loginCode = userToAdd.getLogincode();
		if(loginCode.trim().equals("")) { result.add("\'Utente\' è un campo obbligatorio"); }
		if(loginCode.indexOf('@') == -1 || loginCode.indexOf('.') == -1) {result.add("Il campo \'utente\' deve contenere un indirizzo e mail corretto"); }
//		check password
		String pws = userToAdd.getLoginpassword();
		if(pws.trim().equals("")) { result.add("La password è un campo obbligatorio"); }
//		check tax code
		String taxCode = userToAdd.getTaxcode();
		if(taxCode.trim().equals("")) { result.add("Il codice fiscale è un campo obbligatorio"); }
		if(taxCode.length() != 16) { result.add("Il codice fiscale non è corretto"); }
//		check user code
		User userFake = userService.getUser(userToAdd.getLogincode());
		if(userFake != null) { result.add("l\'utente "+userToAdd.getLogincode()+" è già presente "); }
		
		return result;
	}
	
//	Login
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView viewSimple( @RequestParam(value = "errorAuth", required = false) String error,
			 @RequestParam(value = "logout", required = false)
			String logout,HttpServletRequest request )
	{
		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("errorLogin", "Utente o password errati");
		}

		if (logout != null)
		{
			model.addObject("msg", "Logout eseguito correttamente");
		}
		
		model.setViewName("login");

		return model;
	}


}
