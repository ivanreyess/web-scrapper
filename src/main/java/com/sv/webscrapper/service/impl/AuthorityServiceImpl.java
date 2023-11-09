package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.Authority;
import com.sv.webscrapper.domain.dto.AuthorityDto;
import com.sv.webscrapper.repository.AuthorityRepository;
import com.sv.webscrapper.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

	private final AuthorityRepository authorityRepository;

	public AuthorityDto getAuthorityById(Integer id) {
		return Authority.authorityEntityToDto(authorityRepository.findById(id).orElse(null));
	}
	
	public List<AuthorityDto> getAllAuthorities() {
		return Authority.authorityListEntityToDto(authorityRepository.findAll());
	}
	
	public AuthorityDto createAuthority(Authority authority) {
		return Authority.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public AuthorityDto updateAuthority(Authority authority) {
		return Authority.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public void deleteAuthority(Authority authority) {
		authorityRepository.delete(authority);
	}
}
