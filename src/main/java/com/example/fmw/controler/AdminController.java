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

import com.example.fmw.entity.AdminRegistration;
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
	public String listProduct(Model model) {
		AdminRegistration userRegistrationDto = new AdminRegistration();

		Iterable<User> user = userServiceImpl.listAll();
		model.addAttribute("Users", user);
		model.addAttribute("userRegistrationDto", userRegistrationDto);

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
	public String update( AdminRegistration user, BindingResult result,User users,
			Model model) {
		model.addAttribute("user", user);

		userServiceImpl.update(user, users);
		return list_redirect;
	}
	
    
	@GetMapping("/register")
	public String register(Model model) {
		AdminRegistration userRegistrationDto = new AdminRegistration();
		model.addAttribute("userRegistrationDto", userRegistrationDto);

		return template;
	}

	@PostMapping("/register")
	public String registerUserAccount(
			@Valid @ModelAttribute("userRegistrationDto") AdminRegistration userRegistrationDto, BindingResult result,
			Model model) {
		model.addAttribute("userRegistrationDto", userRegistrationDto);

		User userExists = userService.findByUsername(userRegistrationDto.getUserName());

		if (userExists != null) {
			return "redirect:/register?username";
		}
		// if(result.hasErrors()){ return "admin/auth/register"; }

		userService.save(userRegistrationDto);
		return "redirect:/register?success";
	}
	//"admin/list-admin"


}