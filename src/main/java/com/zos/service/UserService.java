package com.zos.service;

import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.modal.User;

public interface UserService {

	public User registerUser(User user) throws UserException;
	public User updateUser(Integer userId, User user) throws UserException;
}
