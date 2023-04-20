package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;

public interface UserService {

	void saveUser(UserDto userDto);

	List<User> getAllUsers();

}
