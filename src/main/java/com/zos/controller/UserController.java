package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.exception.UserException;
import com.zos.modal.User;
import com.zos.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
		
		User registeredUser=userService.registerUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.OK);
	}
	
	
	@PutMapping("/user/update/{userId}")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user, @PathVariable Integer userId) throws UserException{
		User updatedUser=userService.updateUser(userId, user);
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}

}
