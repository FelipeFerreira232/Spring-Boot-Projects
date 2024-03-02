package com.loginexamplewebscopes.loginexample.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
	private String username;
	private String password;
	private LoginUserManagementService loginUserManagementService;
	
	
	
	public LoginProcessor(LoginUserManagementService loginUserManagementService) {
		super();
		this.loginUserManagementService = loginUserManagementService;
	}



	public boolean login(String username, String password) {
		if(username.equals("Felipe") && password.equals("123")) {
			loginUserManagementService.setUsername(username);
			return true;
		}
		else
			return false;
	}
}
