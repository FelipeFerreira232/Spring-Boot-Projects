package com.loginexamplewebscopes.loginexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loginexamplewebscopes.loginexample.auth.LoginCounts;
import com.loginexamplewebscopes.loginexample.auth.LoginUserManagementService;

@Controller
@RequestMapping("/main")
public class MainController {
	private LoginUserManagementService loginUserManagementService;
	private LoginCounts loginCounts;
	
	
	
	public MainController(LoginUserManagementService loginUserManagementService, LoginCounts loginCounts) {
		super();
		this.loginUserManagementService = loginUserManagementService;
		this.loginCounts = loginCounts;
	}



	@GetMapping
	public String mainPage(@RequestParam(required = false) String logout,
				Model model) {
		if(logout != null) {
			loginUserManagementService.setUsername(null);
		}
		String username = loginUserManagementService.getUsername();
		int numberOfLogins = loginCounts.numberOfLogins();
		if (username == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("username", username);
			model.addAttribute("numberOfLogins", numberOfLogins);
		}
		return "main";
	}
}
