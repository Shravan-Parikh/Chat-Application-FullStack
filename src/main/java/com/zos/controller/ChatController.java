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
	public ResponseEntity<Chat> creatChatHandler(@RequestBody Map<String, Object> data) throws UserException{
		
		Integer reqUserId=(int)data.get("reqUserId");
		Integer userId2=(int)data.get("userId2");
		boolean isGroup=(boolean)data.get("isGroup");
		
		Chat chat=chatService.createChat(reqUserId,userId2,isGroup);
		
		return new ResponseEntity<Chat>(chat,HttpStatus.OK);
	}
	
	@DeleteMapping("/chat/delete/{chatId)/{userId}")
	public ResponseEntity<Chat> deleteChatHandler(@PathVariable Integer chatId, @PathVariable Integer userId) throws ChatException, UserException{
		
		Chat chat=chatService.deleteChat(chatId, userId);
		
		return new ResponseEntity<Chat>(chat,HttpStatus.OK);
	}
}
