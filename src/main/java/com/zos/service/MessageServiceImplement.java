package com.zos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zos.modal.Message;
import com.zos.repository.MessageRepository;

@Service
public class MessageServiceImplement implements MessageService{
	
	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserService userService;
	

	@Override
	public Message sendMessage(Message message) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Message deleteMessage(Integer messageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
