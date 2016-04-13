package gapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class StaffController
{
	@RequestMapping(value = "staff/home.html", method = RequestMethod.GET)
	public String home(ModelMap models)
	{
		return "staff/home";
	}
}
