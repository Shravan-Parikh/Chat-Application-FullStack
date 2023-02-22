package com.zos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zos.modal.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	

}
