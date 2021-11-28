package com.example.fmw.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fmw.entity.User;
import com.example.fmw.services.IUserService;
import com.example.fmw.services.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private IUserService userService;


	private String template = "admin/list-admin";
	private String list_redirect = "redirect:/admin/list";

	@GetMapping("/list")
	public String listProduct(Model model, User user) {

		Iterable<User> users = userServiceImpl.listAll();
		model.addAttribute("Users", users);
		model.addAttribute("userRegistrationDto", user);

		return template;
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {

		userServiceImpl.delete(id);

		return "redirect:/admin/list";
	};

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") long id, Model model) {
		User user = userServiceImpl.get(id);
		model.addAttribute("user", user);

		return "admin/add-edit-user";
	}

	@PostMapping("/update")
	public String update(BindingResult result,User user,
			Model model) {
		model.addAttribute("user", user);

		userServiceImpl.update(user);
		return list_redirect;
	}
	
    
	@GetMapping("/register")
	public String register(Model model,User user) {
		model.addAttribute("userRegistrationDto", user);

		return template;
	}

	@PostMapping("/register")
	public String registerUserAccount(
			@Valid @ModelAttribute("userRegistrationDto") User user, BindingResult result,
			Model model) {
		model.addAttribute("userRegistrationDto", user);

		User userExists = userService.findByUsername(user.getEmail());

		if (userExists != null) {
			return "redirect:/register?username";
		}
		// if(result.hasErrors()){ return "admin/auth/register"; }

		userService.save(user);
		return "redirect:/register?success";
	}
	//"admin/list-admin"


}