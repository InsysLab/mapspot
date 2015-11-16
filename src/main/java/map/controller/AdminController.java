package map.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.AdminUser;
import map.domain.User;
import map.service.*;
import map.serviceimpl.UserServiceImpl;

@Controller
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	AdminUserService adminUserService;

	@Autowired
	MapService mapService;

	@RequestMapping("/admin")
	public String index() {
		return "admin/index";
	}

	@RequestMapping("/admin/users")
	public String listUsers(Model model) {
		// TODO get list of users
		model.addAttribute("users", userService.getAll());
		// System.out.println(userService.getAll().size());
		return "admin/users";
	}

	@RequestMapping("/admin/maps")
	public String listMaps(Model model) {
		// TODO get list of maps
		model.addAttribute("maps", mapService.getAll());
		System.out.println(mapService.getAll());
		return "admin/maps";
	}

	@RequestMapping(value = "/admin/createUser", method = RequestMethod.GET)
	public String createUser(@ModelAttribute("User") User user, Model model) {
		model.addAttribute("user", new User());
		return "admin/createUser";
	}

	@RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
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
	}

	@RequestMapping("/admin/user/edit/{id}")
	public String editUser(@PathVariable("id") int id, @ModelAttribute("User") User user, Model model) {
		// TODO get user from db
		model.addAttribute("user", userService.findUser(id));
		return "admin/editUser";
	}

	@RequestMapping(value = "/admin/user/delete/{id}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return "redirect:/admin/users";
	}

	private long checkDuplicateUser(String username) {
		return userService.getUserByUsername(username);
	}

	@RequestMapping("/admin/adminusers")
	public String listAdminUsers(Model model) { // TODO get list of users
		model.addAttribute("users", adminUserService.getAll()); //
		System.out.println(userService.getAll().size());
		return "admin/adminusers";
	}

	@RequestMapping(value = "/admin/createAdminUser", method = RequestMethod.GET)
	public String createAdminUser(@ModelAttribute("User") AdminUser user, Model model) {
		model.addAttribute("user", new AdminUser());
		return "admin/createAdminUser";
	}

	@RequestMapping(value = "/admin/createAdminUser", method = RequestMethod.POST)
	public String addAdminUser(@Valid @ModelAttribute("User") AdminUser user, BindingResult result) {

		if (result.hasErrors()) { 
			// Load form
			return "/admin/createAdminUser";
		}
		if (checkDuplicateAdminUser(user.getUsername()) > 0) {
			ObjectError err = new ObjectError("username", "Username already exists");
			result.addError(err);
			return "/admin/createAdminUser";
		}
		adminUserService.save(user);
		return "redirect:/admin/adminusers";
	}

	@RequestMapping("/admin/adminuser/edit/{id}")
	public String editAdminUser(@PathVariable("id") int id, @ModelAttribute("User") AdminUser user, Model model) {
		model.addAttribute("user", adminUserService.findUser(id));
		return "admin/editAdminUser";
	}

	@RequestMapping(value = "/admin/adminuser/delete/{id}", method = RequestMethod.POST)
	public String deleteAdminUser(@PathVariable("id") int id) {
		adminUserService.deleteUserById(id);
		return "redirect:/admin/adminusers";
	}

	private long checkDuplicateAdminUser(String username) {
		return adminUserService.getUserByUsername(username);
	}

}
