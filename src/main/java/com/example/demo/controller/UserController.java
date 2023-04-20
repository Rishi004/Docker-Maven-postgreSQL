package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.enums.RestApiResponseStatus;
import com.example.demo.responces.BasicResponse;
import com.example.demo.responces.ContentResponse;
import com.example.demo.services.UserService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.EndPointURI;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = EndPointURI.USER)
	public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.OK, Constants.USER_ADD_SUCCESS),
				HttpStatus.OK);
	}
	
	@GetMapping(value = EndPointURI.USER)
	public ResponseEntity<Object> getAllUser() {
		return new ResponseEntity<>(
				new ContentResponse<>(Constants.USER, userService.getAllUsers(), RestApiResponseStatus.OK), null,
				HttpStatus.OK);
	}
}
