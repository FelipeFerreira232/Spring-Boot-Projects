package com.loginexamplewebscopes.loginexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loginexamplewebscopes.loginexample.auth.LoginCounts;
import com.loginexamplewebscopes.loginexample.auth.LoginProcessor;

@Controller
@RequestMapping("/")
public class LoginController {
	private LoginProcessor loginProcessor;
	private LoginCounts loginCounts;
	

	public LoginController(LoginProcessor loginProcessor, LoginCounts loginCounts) {
		super();
		this.loginProcessor = loginProcessor;
		this.loginCounts = loginCounts;
	}

	@GetMapping
	public String loginPage() {
		return "login";
	}
	
	@PostMapping
	public String login(@RequestParam String username, 
						@RequestParam String password, 
						Model model) {
		boolean auth = loginProcessor.login(username, password);
		if(auth) {
			loginCounts.newLogin();
			return "redirect:/main";
		}
		else
			model.addAttribute("message", "Invalid credentials");
		return "login";
	}
}
