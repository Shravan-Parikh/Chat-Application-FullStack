package com.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.controller.mapper.MessageDtoMapper;
import com.chatapp.dto.MessageDto;
import com.chatapp.exception.ChatException;
import com.chatapp.exception.MessageException;
import com.chatapp.exception.UserException;
import com.chatapp.modal.Message;
import com.chatapp.modal.User;
import com.chatapp.request.SendMessageRequest;
import com.chatapp.response.ApiResponse;
import com.chatapp.service.MessageService;
import com.chatapp.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<MessageDto> sendMessageHandler(@RequestHeader("Authorization")String jwt,  @RequestBody SendMessageRequest req) throws UserException, ChatException{
		
		User reqUser=userService.findUserProfile(jwt);
		
		req.setUserId(reqUser.getId());
		
		Message message=messageService.sendMessage(req);
		
		MessageDto messageDto=MessageDtoMapper.toMessageDto(message);
		
		return new ResponseEntity<MessageDto>(messageDto,HttpStatus.OK);
	}
	
	@GetMapping("/chat/{chatId}")
	public ResponseEntity<List<MessageDto>> getChatsMessageHandler(@PathVariable Integer chatId) throws ChatException{
		
		List<Message> messages=messageService.getChatsMessages(chatId);
		
		List<MessageDto> messageDtos=MessageDtoMapper.toMessageDtos(messages);
		
		return new ResponseEntity<List<MessageDto>>(messageDtos,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{messageId}")
	public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId) throws MessageException{
		
		messageService.deleteMessage(messageId);
		
		ApiResponse res=new ApiResponse("message deleted successfully",true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
