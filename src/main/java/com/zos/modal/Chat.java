package com.zos.modal;

import java.util.ArrayList;
import java.util.HashSet;

import com.zos.dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Chats")
public class Chat {
	
	private Integer id;
	private String chat_name;
	
	@ElementCollection
	@Embedded
	private HashSet<UserDto> users =new HashSet<>();
	
	@OneToMany(mappedBy = "chat",cascade = CascadeType.ALL)
	private ArrayList<Message> messages=new ArrayList<>();

	

}
