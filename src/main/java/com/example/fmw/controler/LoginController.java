package com.example.fmw.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fmw.services.IUserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public String login(Model model) {

		return "login";
	}


	
	/*
	 * @GetMapping("/register_user") public String registeruser(Model model) {
	 * model.addAttribute("userRegistrationDto", userRegistrationDto);
	 * 
	 * return "user/registerUsers"; }
	 * 
	 * @PostMapping("/register_user") public String registerUser(
	 * 
	 * @Valid @ModelAttribute("userRegistrationDto") AdminRegistration
	 * userRegistrationDto, BindingResult result, Model model) {
	 * model.addAttribute("userRegistrationDto", userRegistrationDto);
	 * 
	 * User userExists =
	 * userService.findByUsername(userRegistrationDto.getUserName());
	 * 
	 * if (userExists != null) { return "redirect:/register_user?username"; } //
	 * if(result.hasErrors()){ return "admin/auth/register"; }
	 * 
	 * userService.save2(userRegistrationDto); return
	 * "redirect:/register_user?success"; }
	 */
	

	

}
