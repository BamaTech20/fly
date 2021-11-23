package com.example.fmw.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fmw.entity.Billet;
import com.example.fmw.repository.IBilletRepository;

@Controller
@RequestMapping("/billet")
public class DashboardBillet {
	
	@Autowired
	private IBilletRepository ibillet;


	@GetMapping("/saveBillet")
	public String register(Model model, Billet billet) {
		model.addAttribute("billet", billet);

		return "admin/EnregistrementBillet";
	}

	@PostMapping("/saveBillet")
	public String registerUserAccount(@Valid @ModelAttribute("billet") Billet billet, BindingResult result,
			Model model) {
		model.addAttribute("billet", billet);
		
		
		
		 if(result.hasErrors()){ return "admin/auth/register"; }

		 ibillet.save(billet);
		return "redirect:/saveBillet?success";
	}

}
