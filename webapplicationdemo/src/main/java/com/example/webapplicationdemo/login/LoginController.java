package com.example.webapplicationdemo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private LoginProcessor loginProcessor;
	@Autowired
	private LoggedUserManagementService userManagement;
	
	@GetMapping("/")
	public String loginPage() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String loginResponse(@RequestParam String username,
								@RequestParam String password,
								Model model) {
		boolean loggedIn = loginProcessor.userVerification(username, password);
		
		if(loggedIn) {
			//model.addAttribute("message", "You're logged in");
			String user = userManagement.getUsername();
			model.addAttribute("username", user);
			return "main.html";
		}
		else {
			model.addAttribute("message", "Incorrect Information");
			return "login.html";
		}
	}
	
	@GetMapping("/main")
	public String welcomePage(@RequestParam(required = false) String logout, Model model) {
		if (logout != null) {
			userManagement.setUsername(null);
		}
		String username = userManagement.getUsername();
		if (username == null) {
			return "redirect:/";
		}
		model.addAttribute("username" , username);
			return "main.html";
	}
}
