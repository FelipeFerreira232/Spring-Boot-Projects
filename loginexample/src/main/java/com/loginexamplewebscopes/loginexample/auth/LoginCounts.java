package com.loginexamplewebscopes.loginexample.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class LoginCounts {
	private int loginCounts;
	
	public void newLogin() {
		loginCounts++;
	}
	
	public int numberOfLogins() {
		return loginCounts;
	}
}
