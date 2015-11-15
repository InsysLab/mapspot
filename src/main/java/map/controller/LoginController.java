package map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.User;
import map.service.SignUpService;
import map.service.UserService;

@Controller
public class LoginController {

	
	  @Autowired UserService userService;
	//SignUpImpl signupService = new SignUpImpl();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("signup") User user) {
		//System.out.println(user.getFirstname());
		//signupService.save(user);
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("signup") User user) {
		//System.out.println(user.getFirstname());
		userService.save(user);
		return "signup";
	}
}
