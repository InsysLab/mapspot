package map.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.User;
import map.service.*;
import map.serviceimpl.UserServiceImpl;

@Controller
public class AdminController {
	@Autowired
	UserService userService;
	
	@Autowired
	MapService mapService;
	
	@RequestMapping("/admin")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping("/admin/users")
	public String listUsers(Model model){
		//TODO get list of users
		model.addAttribute("users", userService.getAll());
		//System.out.println(userService.getAll().size());
		return "admin/users";
	}
	
	@RequestMapping("/admin/maps")
	public String listMaps(Model model){
		//TODO get list of maps
		model.addAttribute("maps", mapService.getAll());
		return "admin/maps";
	}
	
	@RequestMapping(value = "/admin/createUser", method=RequestMethod.GET)
	public String createUser(@ModelAttribute("User")User user, Model model){
		model.addAttribute("user", new User());
		return "admin/createUser";
	}
	
	@RequestMapping(value="/admin/createUser", method=RequestMethod.POST)
	public String addUser(Model model,@Valid @ModelAttribute("User")User user, BindingResult result){
		System.out.println("ting");
		if(result.hasErrors()){
			//Load form
			return "admin/createUser";
		}
		userService.save(user);
		return "admin/list";
	}
	
	@RequestMapping("/admin/user/edit/{id}")
	public String editUser(@PathVariable("id")int id, Model model){
		//TODO get user from db
		model.addAttribute("user", userService.findUser(id));
		return "admin/createUser";
	}
}
