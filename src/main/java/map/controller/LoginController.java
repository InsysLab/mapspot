package map.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.User;
import map.service.AdminUserService;
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

		model.addAttribute("errorMessage", "Invalid username or password");
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
	public String signupPost(@Valid @ModelAttribute("signup") User user, BindingResult result) {
		System.out.println("#############"+user.getUsername());
		if(result.hasErrors()){
			return "signup";
		}
		if(userService.getUserCountByUsername(user.getUsername()) == 0){
			userService.save(user);
		}
		
		return "home";
	}
	
	private long checkDuplicateUser(String username) {
		return userService.getUserCountByUsername(username);
	}
	/*private User checkDuplicateUser(String username) {
		return  userService.findUserByUsername(username);
			}
*/
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateProfile(@Valid @ModelAttribute("User") User user, BindingResult result) {
		System.out.println("#############"+user.getUsername());
		if(result.hasErrors()){
			return "/user/update";
		}
		if (user.getPersonId() == 0) {
			if (checkDuplicateUser(user.getUsername()) > 0) {
				ObjectError err = new ObjectError("username", "Username already exists");
				result.addError(err);
				return "/user/update";
			}
		}
		userService.save(user);
		return "redirect:/home";
	}
	//..
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("User") User user, BindingResult result) {

		if (result.hasErrors()) {
			// Load form
			return "/admin/createUser";
		}
		if (user.getPersonId() == 0) {
			if (checkDuplicateUser(user.getUsername()) > 0) {
				ObjectError err = new ObjectError("username", "Username already exists");
				result.addError(err);
				return "/admin/createUser";
			}
		}
		userService.save(user);
		return "redirect:/admin/users";
	}*/
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error(Model model) {
		return "403";
	}	
}
