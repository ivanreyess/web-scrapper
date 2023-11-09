package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.User;
import com.sv.webscrapper.domain.dto.UserDto;
import com.sv.webscrapper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui/user")
public class UserController {

	private final UserService userService;
	

	@GetMapping("")
	public String register(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("user", new User());
		return "register";
	}


	@PostMapping("")
	public String register(@ModelAttribute User user) {
		userService.createUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
}
