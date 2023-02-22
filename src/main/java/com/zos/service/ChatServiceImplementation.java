package com.zos.service;

import com.zos.dto.UserDto;
import com.zos.exception.ChatException;
import com.zos.exception.UserException;
import com.zos.modal.Chat;
import com.zos.repository.ChatRepository;

public class ChatServiceImplementation implements ChatService {
	
	private UserService userService;
	
	private ChatRepository chatRepo;

	@Override
	public Chat createChat(Integer reqUserId, Integer userId2, boolean isGroup) throws UserException {
		// TODO Auto-generated method stub
		
		UserDto reqUser=userService.findUserById(reqUserId);
		UserDto user2 = userService.findUserById(userId2);
		
		
		
		Chat chat=new Chat();
		
		chat.setCreated_by(reqUser);
		chat.getUsers().add(reqUser);
		chat.getUsers().add(user2);
		chat.setIs_group(isGroup);
		
		return chatRepo.save(chat);
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
