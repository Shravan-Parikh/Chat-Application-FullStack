package com.zos.modal;

import java.util.ArrayList;
import java.util.HashSet;

import com.zos.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Chats")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String chat_name;
	private String chat_image;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean is_group;
	
	@Embedded
	@AttributeOverride(name="id",column = @Column(name="user_id"))
	@AttributeOverride(name="email",column = @Column(name="user_email"))
	@AttributeOverride(name="full_name",column = @Column(name="user_full_name"))
	@AttributeOverride(name="profile_picture",column = @Column(name="user_profile_picture"))
	private UserDto created_by;
	
	@ElementCollection
	@Embedded
	private HashSet<UserDto> users =new HashSet<>();
	
	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
	private ArrayList<Message> messages=new ArrayList<>();

	public Chat() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Chat(Integer id, String chat_name, String chat_image, Boolean is_group, UserDto created_by,
			HashSet<UserDto> users, ArrayList<Message> messages) {
		super();
		this.id = id;
		this.chat_name = chat_name;
		this.chat_image = chat_image;
		this.is_group = is_group;
		this.created_by = created_by;
		this.users = users;
		this.messages = messages;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChat_name() {
		return chat_name;
	}

	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}

	public HashSet<UserDto> getUsers() {
		return users;
	}

	public void setUsers(HashSet<UserDto> users) {
		this.users = users;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
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

	

}
