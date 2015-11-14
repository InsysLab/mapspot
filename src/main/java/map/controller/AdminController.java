package map.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.User;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping("/admin/users")
	public String listUsers(Model model){
		//TODO get list of users
		return "admin/users";
	}
	
	@RequestMapping("/admin/maps")
	public String listMaps(Model model){
		//TODO get list of maps
		return "admin/maps";
	}
	@RequestMapping(value = "/admin/createUser", method=RequestMethod.GET)
	public String createUser(@ModelAttribute("User")User user){
		return "admin/createUser";
	}
	
	@RequestMapping(value="/admin/createUser", method=RequestMethod.POST)
	public String addUser(Model model,@Valid @ModelAttribute("User")User user, BindingResult result){
		if(result.hasErrors()){
			//Load form
		}
		return "admin/createUser";
	}
	
	@RequestMapping("/admin/user/edit/{id}")
	public String editUser(@PathVariable("id")String id, Model model){
		//TODO get user from db
		return "admin/createUser";
	}
}
