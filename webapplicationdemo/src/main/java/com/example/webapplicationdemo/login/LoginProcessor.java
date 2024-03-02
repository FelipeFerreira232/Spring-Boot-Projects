package com.example.webapplicationdemo.login;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
	
	private final LoggedUserManagementService loggedUserManagementService;
	
	public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	public boolean userVerification(String username, String password) {
		
		boolean logginResult = false;
		
		if ("Felipe".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
			logginResult = true;
			//model.addAttribute("message", "You're logged in");
			loggedUserManagementService.setUsername(username);
			return logginResult;
		}
		else {
			//model.addAttribute("message", "Incorrect Information");
			return logginResult;
		}
	}
}
