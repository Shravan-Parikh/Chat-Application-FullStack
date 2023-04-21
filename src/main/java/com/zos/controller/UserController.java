package com.zos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.controller.mapper.UserDtoMapper;
import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.modal.User;
import com.zos.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PutMapping("/user/update/{userId}")
	public ResponseEntity<UserDto> updateUserHandler(@RequestBody User user, @PathVariable Integer userId) throws UserException{
		User updatedUser=userService.updateUser(userId, user);
		UserDto userDto=UserDtoMapper.toUserDTO(updatedUser);

		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}

}
