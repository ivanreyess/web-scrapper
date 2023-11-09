package com.sv.webscrapper.domain.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UserDto(
		Integer id,
		String username,
		List<AuthorityDto> authorities,
		Boolean accountNonExpired,
		Boolean accountNonLocked,
		Boolean credentialsNonExpired,
		Boolean enabled,
		String firstName,
		String lastName,
		String emailAddress,
		LocalDate birthdate) {}
