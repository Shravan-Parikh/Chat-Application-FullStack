package com.zos.modal;

import java.time.LocalDateTime;

import com.zos.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String content;
	
	private LocalDateTime timeStamp;
	private Boolean is_read;
	
	@Embedded
	@AttributeOverride(name="id", column=@Column(name="user_id"))
	private UserDto userDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chat_id")
	private Chat chat;
	
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
