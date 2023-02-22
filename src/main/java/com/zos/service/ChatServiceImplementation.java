package com.zos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zos.dto.UserDto;
import com.zos.exception.ChatException;
import com.zos.exception.UserException;
import com.zos.modal.Chat;
import com.zos.repository.ChatRepository;

@Service
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
	public Chat findChatById(Integer chatId) throws ChatException {
		// TODO Auto-generated method stub
		Optional<Chat> chat =chatRepo.findById(chatId);
		
		if(chat.isPresent()) {
			return chat.get();
		}
		throw new ChatException("Chat not exist with id "+chatId);
	}

	@Override
	public Chat findAllChatByUserId(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException {
		// TODO Auto-generated method stub
		
		UserDto user=userService.findUserById(userId);
		Chat chat=findChatById(chatId);
		
		if((chat.getCreated_by().getId()==user.getId()) && !chat.getIs_group() ) {
			chatRepo.deleteById(chat.getId());
			
			return chat;
		}
		
		throw new ChatException("you dont have access to delete this chat");
	}

}
