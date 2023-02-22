package com.zos.service;

import com.zos.exception.ChatException;
import com.zos.exception.UserException;
import com.zos.modal.Chat;
import com.zos.repository.ChatRepository;

public class ChatServiceImplementation implements ChatService {
	
	private UserService userService;
	
	private ChatRepository chatRepo;

	@Override
	public Chat createChat(Integer reqUserId, Integer userId2) throws UserException {
		// TODO Auto-generated method stub
		
//		User reqUser=userService
		return null;
	}

	@Override
	public Chat deleteChat(Integer chatId) throws ChatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chat findChatById(Integer chatId) throws ChatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chat findAllChatByUserId(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
