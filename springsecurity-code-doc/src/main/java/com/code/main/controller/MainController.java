package com.code.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class MainController {

	@GetMapping("/balance")
	public ResponseEntity<String> checkBalance() {

		return new ResponseEntity<String>("check balance called.", HttpStatus.OK);
	}

	@GetMapping("/loan")
	public ResponseEntity<String> loan() {

		return new ResponseEntity<String>("loan called.", HttpStatus.OK);
	}

	@GetMapping("/contact")
	public ResponseEntity<String> contact() {

		return new ResponseEntity<String>("contact called", HttpStatus.OK);
	}

	@GetMapping("/info")
	public ResponseEntity<String> info() {

		return new ResponseEntity<String>("info called", HttpStatus.OK);
	}

}
