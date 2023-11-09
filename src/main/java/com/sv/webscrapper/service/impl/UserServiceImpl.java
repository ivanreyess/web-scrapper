package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.User;
import com.sv.webscrapper.domain.dto.UserDto;
import com.sv.webscrapper.repository.UserRepository;
import com.sv.webscrapper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

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
		return User.userEntityToDto(userRepository.save(user));
	}
	
	public UserDto updateUser(User user) {
		return User.userEntityToDto(userRepository.save(user));
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
}
