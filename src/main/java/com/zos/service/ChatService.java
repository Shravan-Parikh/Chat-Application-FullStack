package com.zos.service;

import com.zos.exception.ChatException;
import com.zos.exception.UserException;
import com.zos.modal.Chat;

public interface ChatService {

	public Chat createChat(Integer reqUserId, Integer userId2, boolean isGroup) throws UserException;
	
	public Chat findChatById(Integer chatId) throws ChatException;
	
	public Chat findAllChatByUserId(Integer userId) throws UserException;
	
	public Chat deleteChat(Integer chatId) throws ChatException;
	
	
}
