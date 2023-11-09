package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.dto.UserDto;
import com.sv.webscrapper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final UserService userService;
	
	@GetMapping("/")
	public String home(Model model, Authentication authentication) {
		if (authentication != null) {
			UserDto user = userService.getLoginUser();
			model.addAttribute("user", user);
		}
		model.addAttribute("title", "Home");
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login");
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("loginError", true);
		return "login";
	}
}
