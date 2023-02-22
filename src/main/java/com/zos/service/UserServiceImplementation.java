package com.zos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zos.dto.UserDto;
import com.zos.exception.UserException;
import com.zos.modal.User;
import com.zos.repository.UserRepository;

@Service
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

	@Override
	public User updateUser(Integer userId, User user) throws UserException {
		// TODO Auto-generated method stub
		
		Optional<User> opt=userRepo.findById(userId);
		
		if(opt.isPresent()) {
			return userRepo.save(user);
		}
		
		throw new UserException("user not found with id "+userId);
	}

	@Override
	public UserDto findUserById(Integer userId) throws UserException {
		
		Optional<User> opt=userRepo.findById(userId);
		
		if(opt.isPresent()) {
			User user=opt.get();
			UserDto userDto=new UserDto();
			
			userDto.setEmail(user.getEmail());
			userDto.setFull_name(user.getFull_name());
			userDto.setProfile_pic(user.getProfile_picture());
			userDto.setId(user.getId());
			
			return userDto;
		}
		throw new UserException("user not exist with id "+userId);
	}

}
