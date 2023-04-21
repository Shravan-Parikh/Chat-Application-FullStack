package com.zos.controller.mapper;

import java.util.HashSet;

import com.zos.dto.UserDto;
import com.zos.modal.User;

public class UserDtoMapper {

	
	public static UserDto toUserDTO(User user) {
		
		UserDto userDto=new UserDto();
		
		userDto.setEmail(user.getEmail());
		userDto.setFull_name(user.getFull_name());
		userDto.setId(user.getId());
		userDto.setProfile_pic(user.getProfile_picture());
		
		return userDto;
		
	}
	
	public static HashSet<UserDto> toUserDtos(HashSet<User> users){
		HashSet<UserDto> userDtos=new HashSet<>();
		
		for(User user:users) {
			UserDto userDto=toUserDTO(user);
			userDtos.add(userDto);
		}
		
		return userDtos;
	}
}
