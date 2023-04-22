package com.zos.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.zos.modal.User;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;


public class ChatDto {

	
	private String chat_name;
	private String chat_image;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean is_group;
	
	private HashSet<UserDto> admins;
	
	private UserDto created_by;

	private HashSet<UserDto> users =new HashSet<>();
	
	private List<MessageDto> messages=new ArrayList<>();

	public ChatDto() {
		// TODO Auto-generated constructor stub
	}

	
	public ChatDto(String chat_name, String chat_image, Boolean is_group, HashSet<UserDto> admins, UserDto created_by,
			HashSet<UserDto> users, List<MessageDto> messages) {
		super();
		this.chat_name = chat_name;
		this.chat_image = chat_image;
		this.is_group = is_group;
		this.admins = admins;
		this.created_by = created_by;
		this.users = users;
		this.messages = messages;
	}


	public HashSet<UserDto> getAdmins() {
		return admins;
	}

	public void setAdmins(HashSet<UserDto> admins) {
		this.admins = admins;
	}

	public List<MessageDto> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageDto> messages) {
		this.messages = messages;
	}
	public String getChat_name() {
		return chat_name;
	}

	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}

	public String getChat_image() {
		return chat_image;
	}

	public void setChat_image(String chat_image) {
		this.chat_image = chat_image;
	}

	public Boolean getIs_group() {
		return is_group;
	}

	public void setIs_group(Boolean is_group) {
		this.is_group = is_group;
	}

	public UserDto getCreated_by() {
		return created_by;
	}

	public void setCreated_by(UserDto created_by) {
		this.created_by = created_by;
	}

	public HashSet<UserDto> getUsers() {
		return users;
	}

	public void setUsers(HashSet<UserDto> users) {
		this.users = users;
	}
	
	
}
