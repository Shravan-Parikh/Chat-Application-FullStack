package com.zos.modal;

import java.time.LocalDateTime;

import com.zos.dto.UserDto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String content;
	
	private LocalDateTime timeStamp;
	private Boolean is_read;
	
	@Embedded
	private UserDto userDto;
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Message(Integer id, String content, LocalDateTime timeStamp, Boolean is_read, UserDto userDto) {
		super();
		this.id = id;
		this.content = content;
		this.timeStamp = timeStamp;
		this.is_read = is_read;
		this.userDto = userDto;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIs_read() {
		return is_read;
	}

	public void setIs_read(Boolean is_read) {
		this.is_read = is_read;
	}

	

}
