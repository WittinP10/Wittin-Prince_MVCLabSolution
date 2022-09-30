package com.collegefest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	
	public String openingPage() {
		
		return "main-menu";
	}
	
	
	
}
