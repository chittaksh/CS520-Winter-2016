package gapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import gapp.model.User;
import gapp.model.dao.*;
import gapp.web.validator.LoginValidator;
import gapp.web.validator.RegistrationValidator;

@Controller
@SessionAttributes("user")
public class HomeController
{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RegistrationValidator registrationValidator;

	@Autowired
	private LoginValidator loginValidation;

	@RequestMapping(value = { "/home.html",
			"/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap models)
	{
		models.put("user", new User());
		return "home";
	}

	@RequestMapping(value = { "/home.html",
			"/index.html" }, method = RequestMethod.POST)
	public String index(@ModelAttribute User user, ModelMap models,
			BindingResult result) throws Exception
	{
		String strUrl;

		loginValidation.validate(user, result);

		if (!result.hasErrors())
		{
			if (userDao.checkEmail(user.getStrEmail().toLowerCase()))
			{
				User tempUser = userDao
						.getUserByEmail(user.getStrEmail().toLowerCase());
				if (tempUser.getStrPassword().equals(user.getStrPassword()))
				{
					user = tempUser;
					models.put("user", user);
					switch (user.getRole().getIntRoleId())
					{
					case 1:
						strUrl = "redirect:admin/home.html";
						break;

					case 2:
						strUrl = "redirect:staff/home.html";
						break;

					default:
						strUrl = "redirect:student/home.html";
						break;
					}
				}
				else
				{
					models.put("errorMessage", "Incorrect Password.");
					strUrl = "home";
				}
			}
			else
			{
				models.put("errorMessage", "Incorrect Credentials.");
				strUrl = "home";
			}
		}
		else
		{
			return "home";
		}
		
		//Exception ex = new Exception("Hello World");
		//throw ex;
		
		return strUrl;
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String register(ModelMap models)
	{
		models.put("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public String register(@ModelAttribute User user,
			@RequestParam String strConfirmPassword, ModelMap models,
			BindingResult result)
	{
		registrationValidator.validate(user, result);
		
		System.out.println(result.toString());
		
		if (!result.hasErrors())
		{
			if (user.getStrPassword().equals(strConfirmPassword))
			{
				if (!userDao.checkEmail(user.getStrEmail()))
				{
					user.setRole(roleDao.getRole(3));
					user.setEnabled(true);
					user.setStrEmail(user.getStrEmail().toLowerCase());
					userDao.saveUser(user);
					return "redirect:home.html";
				}
				else
				{
					models.put("errorMessage", "Email already exists.");
					return "register";
				}
			}
			else
			{
				models.put("errorMessage",
						"Password and Confirm Password do not match.");
				return "register";
			}
		}
		else
		{
			return "register";
		}
	}

	@RequestMapping(value = "/logout.html")
	public String logout(ModelMap models,
			SessionStatus session)
	{
		session.setComplete();
		return "redirect:home.html";
	}
}
