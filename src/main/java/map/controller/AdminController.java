package map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
