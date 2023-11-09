package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.dto.AuthorityDto;
import com.sv.webscrapper.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class AuthorityController {
	
	private final AuthorityService authorityService;
	
	@GetMapping("/authorities")
	public String getAuthorities(Model model) {
		List<AuthorityDto> authorities = authorityService.getAllAuthorities();
		model.addAttribute("title", "Athorities");
		model.addAttribute("authorities", authorities);
		return "authorities";
	}

	@GetMapping("/authorities/{id}")
	public AuthorityDto getauthorityById(@PathVariable Integer id) {
		return authorityService.getAuthorityById(id);
	}
}
