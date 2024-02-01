package com.chatapp.service;

import java.util.List;

import com.chatapp.exception.UserException;
import com.chatapp.modal.User;
import com.chatapp.request.UpdateUserRequest;

public interface UserService {
	
	public User findUserProfile(String jwt);
	
	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;
	
	public User findUserById(Integer userId) throws UserException;
	
	public List<User> searchUser(String query);
}
