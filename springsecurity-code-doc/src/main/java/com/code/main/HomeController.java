package com.code.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
public class HomeController {

	@GetMapping("")
	public String home() {

		return "authentication success";
	}

	@GetMapping("/login")
	public String viewHomePage() {

		return "login";
	}
}
