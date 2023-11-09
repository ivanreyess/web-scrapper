package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.User;
import com.sv.webscrapper.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto getLoginUser();

    public UserDto getUserById(Integer id);

    public List<UserDto> getAllUsers();

    public UserDto createUser(User user);

    public UserDto updateUser(User user);

    public void deleteUser(User user);
}
