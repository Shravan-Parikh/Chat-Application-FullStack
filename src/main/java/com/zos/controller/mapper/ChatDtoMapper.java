package com.zos.controller.mapper;

import java.util.HashSet;
import java.util.List;

import com.zos.dto.ChatDto;
import com.zos.dto.MessageDto;
import com.zos.dto.UserDto;
import com.zos.modal.Chat;

public class ChatDtoMapper {
	
	public static ChatDto toChatDto(Chat chat) {
		
		UserDto userDto=UserDtoMapper.toUserDTO(chat.getCreated_by());
		List<MessageDto> messageDtos=MessageDtoMapper.toMessageDtos(chat.getMessages());
		HashSet<UserDto> userDtos=UserDtoMapper.toUserDtos(chat.getUsers());
		
		ChatDto chatDto=new ChatDto();
		
		chatDto.setChat_image(chat.getChat_image());
		chatDto.setChat_name(chat.getChat_name());
		chatDto.setCreated_by(userDto);
		chatDto.setIs_group(chat.getIs_group());
		chatDto.setMessages(messageDtos);
		chatDto.setUsers(userDtos);
		
		
		return chatDto;
	}

}
