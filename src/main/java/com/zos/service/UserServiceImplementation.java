package com.zos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.modal.User;
import com.zos.repository.UserRepository;

public class UserServiceImplementation implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		
		User newUser= new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setFull_name(user.getFull_name());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepo.save(newUser);
	}

}
