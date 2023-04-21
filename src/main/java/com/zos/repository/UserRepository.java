package com.zos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zos.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmail(String email);

}
