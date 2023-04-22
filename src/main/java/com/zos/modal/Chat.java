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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@OneToMany
	private HashSet<User> admins;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean is_group;
	
	@ManyToOne
	private User created_by;
	
	@ManyToMany
	private HashSet<User> users =new HashSet<>();
	
	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
	private ArrayList<Message> messages=new ArrayList<>();

	public Chat() {
		// TODO Auto-generated constructor stub
	}
	
	public Chat(Integer id, String chat_name, String chat_image, HashSet<User> admins, Boolean is_group,
			User created_by, HashSet<User> users, ArrayList<Message> messages) {
		super();
		this.id = id;
		this.chat_name = chat_name;
		this.chat_image = chat_image;
		this.admins = admins;
		this.is_group = is_group;
		this.created_by = created_by;
		this.users = users;
		this.messages = messages;
	}
	
	public HashSet<User> getAdmins() {
		return admins;
	}

	public void setAdmins(HashSet<User> admins) {
		this.admins = admins;
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

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
	

}
