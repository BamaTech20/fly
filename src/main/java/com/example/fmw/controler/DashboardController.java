package com.example.fmw.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fmw.entity.User;
import com.example.fmw.services.UserService;

@Controller
public class DashboardController {
	
	@Autowired
	private UserService userService;


    @RequestMapping("/")
    public String accueil(Model model) {
        return "accueil";
    }
    
    
    @RequestMapping("/index")
    public String index(Model model) {
    	Iterable<User> user = userService.listAll();
		model.addAttribute("Users", user);

        return "index";
    }
	/*
	 * @GetMapping("/register") public String register(Model model) {
	 * AdminRegistration userRegistrationDto = new AdminRegistration();
	 * model.addAttribute("userRegistrationDto", userRegistrationDto);
	 * 
	 * return "admin/registerAdmin"; }
	 * 
	 * @PostMapping("/register") public String registerUserAccount(
	 * 
	 * @Valid @ModelAttribute("userRegistrationDto") AdminRegistration
	 * userRegistrationDto, BindingResult result, Model model) {
	 * model.addAttribute("userRegistrationDto", userRegistrationDto);
	 * 
	 * User userExists =
	 * userService.findByUsername(userRegistrationDto.getUserName());
	 * 
	 * if (userExists != null) { return "redirect:/register?username"; } //
	 * if(result.hasErrors()){ return "admin/auth/register"; }
	 * 
	 * userService.save(userRegistrationDto); return "redirect:/register?success"; }
	 */  

    // Added to test 500 page
//    @RequestMapping(path = "/tigger-error", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void error500() throws Exception {
//        throw new Exception();
//    }

}
