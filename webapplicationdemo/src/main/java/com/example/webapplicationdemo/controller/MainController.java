package com.example.webapplicationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/home")
	public String home(@RequestParam(required=false) String color, 
						@RequestParam(required=false) String username, 
						Model model) {
		
		model.addAttribute("username",username);
		model.addAttribute("color", color);
		return "home.html";
	}
	
	@GetMapping("/home2/{username}/{color}")
	public String home2(@PathVariable String username, 
						@PathVariable String color,
						Model model) {
		
		model.addAttribute("username", username);
		model.addAttribute("color", color);
		return "home.html";
	}
}
