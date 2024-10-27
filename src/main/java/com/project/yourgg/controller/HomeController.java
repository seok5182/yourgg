package com.project.yourgg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home() {
		return "redirect:/your.gg/ko/kr";
	}

	@GetMapping("/your.gg")
	public String home2() {
		return "redirect:/your.gg/ko/kr";
	}

	@GetMapping("/your.gg/ko/kr")
	public String search() {
		return "search";
	}
}
