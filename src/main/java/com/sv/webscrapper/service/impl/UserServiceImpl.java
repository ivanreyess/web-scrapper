package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.Authority;
import com.sv.webscrapper.domain.User;
import com.sv.webscrapper.domain.dto.UserDto;
import com.sv.webscrapper.repository.UserRepository;
import com.sv.webscrapper.service.AuthorityService;
import com.sv.webscrapper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final AuthorityService authorityService;
	private final PasswordEncoder passwordEncoder;

	public UserDto getLoginUser() {
		return User.userEntityToDto(userRepository.findLoginUser().orElse(null));
	}
	
	public UserDto getUserById(Integer id) {
		return User.userEntityToDto(userRepository.findById(id).orElse(null));
	}
	
	public List<UserDto> getAllUsers() {
		return User.userListEntityToDto(userRepository.findAll());
	}
	
	public UserDto createUser(User user) {
		List<Authority> authorities = Stream.of(authorityService.findByAuthority("USER")).map(Authority::authorityDtoToEntity).toList();
		user.setEnabled(true);
		user.setEmailAddress(user.getUsername());
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(authorities);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return User.userEntityToDto(userRepository.save(user));
	}
	
	public UserDto updateUser(User user) {
		return User.userEntityToDto(userRepository.save(user));
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
}
