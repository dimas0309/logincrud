package com.dagtech.logincrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// show the main page
	@GetMapping("/main")
	public String showTestPage(Model model) {
		
		model.addAttribute("theDate", new java.util.Date());
		
		return "main";
		
		
	}

}
