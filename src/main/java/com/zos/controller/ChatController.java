package com.zos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zos.controller.mapper.ChatDtoMapper;
import com.zos.dto.ChatDto;
import com.zos.exception.ChatException;
import com.zos.exception.UserException;
import com.zos.modal.Chat;
import com.zos.repository.ChatRepository;
import com.zos.service.ChatService;

@RestController
public class ChatController {

//	private ChatRepository chatRepo;
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping("/chat/create")
	public ResponseEntity<ChatDto> creatChatHandler(@RequestBody Map<String, Object> data) throws UserException{
		
		Integer reqUserId=(int)data.get("reqUserId");
		Integer userId2=(int)data.get("userId2");
		boolean isGroup=(boolean)data.get("isGroup");
		
		Chat chat=chatService.createChat(reqUserId,userId2,isGroup);
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/chat/delete/{chatId}/{userId}")
	public ResponseEntity<ChatDto> deleteChatHandler(@PathVariable Integer chatId, @PathVariable Integer userId) throws ChatException, UserException{
		
		Chat chat=chatService.deleteChat(chatId, userId);
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
}
